import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
/** ������������������ʵ����ĿҪ��Ĺ��� **/
 /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
    static long caculateSubs(int n, int[][] array) {
        long answ[] = new long[1];
        boolean[] visited = new boolean[n];
        vaild(n,0,array,visited,answ);
        return answ[0];
    }
    static void vaild(int n,int cur,int [][]array,boolean[] visited,long[] answ){
        if(cur==n) {
            answ[0]++;
            return;
        }
        for(int i=0;i<array[cur].length;i++){
            if(array[cur][i]==1){//�ҵ��붩��de
                if(visited[i]==false){
                    visited[i] = true;
                    vaild(n,cur+1,array,visited,answ);
                    visited[i] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;
            
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());//���topic������

        int _array_rows = 0;
        int _array_cols = 0;
        _array_rows = _n;
        _array_cols = _n;
        
        int[][] _array = new int[_array_rows][_array_cols];
        for(int _array_i=0; _array_i<_array_rows; _array_i++) {
            for(int _array_j=0; _array_j<_array_cols; _array_j++) {
                _array[_array_i][_array_j] = in.nextInt();
                
            }
        }
        
        if(in.hasNextLine()) {
          in.nextLine();
        }
  
        res = caculateSubs(_n, _array);
        System.out.println(String.valueOf(res));  

    }
}