import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int resolve(list<int> A) {
        int[] tree = new int[16];
        int[] notnull = new int[16];
        for(int i=1,j=0;i<=4&&j+1<A.size();i++){
            int L= i;
            list<int> level = new ArrayList<int>();
            while(A[j]/100==i){
                int num = A[j];
                int P = (num-L*100)/10;
                int v = num%10;
                level.add(v);
            }
            if(L==1&&P==1){
                 tree[1] = v;
                 notnull[1] = 1;
            }else{
                int lastl = L-1,nth=p;
                for(int p=(1<<(lastl-1));p<(1<<lastl);p++){
                    if(notnull[p]==1){
                        notnull[2*p] = 1;
                        tree[2*p] = 
                    }
                }
            }
            
        }

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
        List<int> list = new ArrayList<int>();
        while(in.hasNextInt()){
            int a = in.nextInt();
            ArrayList.add(a);
        } 
        int _A;
        _A = Integer.parseInt(in.nextLine().trim());
  
        res = resolve(_A);
        System.out.println(String.valueOf(res));    

    }
}
