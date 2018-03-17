//化上三角，求01矩阵的秩，只是操作是异或
//O(n^2) 每次取最大的数换到上面，然后下面的数去清除当前的最高位，再取清除后数中的最大，置换循环
import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] a = new int[n];
            int maxi = 0;
            for(int i=0;i<n;i++){
                a[i] = input.nextInt();
                if(a[maxi]<a[i]) maxi = i;
            }
            swap(0,maxi,a);
            for(int b=0;b<n-1;b++){
                maxi = -1;
                for(int i=b+1;i<n;i++){
                    if((a[i]^a[b])<a[i]){
                        a[i] = a[i]^a[b];
                    }
                    if(maxi==-1||a[maxi]<a[i]) maxi = i;
                }
                swap(b+1,maxi,a);
            }
            int ans = 0;
            for(int i=0;i<n;i++){
                //System.out.println(Integer.toBinaryString(a[i]));
                if(a[i]>0) ans++;
            }
            System.out.println(ans);
        }
    }
    public static void swap(int i,int j,int[] a){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}