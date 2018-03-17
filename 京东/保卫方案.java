import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i] = input.nextInt();
            }
            boolean[][] oneway = new boolean[n][n];
            boolean[][] twoway = new boolean[n][n];
            for(int i=0;i<n;i++){
                int onemax = Integer.MIN_VALUE;
                for(int j=i;j!=i;j=(j+1)%n){
                    if(a[j]>=onemax){
                        onemax = a[j];
                        oneway[i][j] = true;
                    }
                }
                int twomax = Integer.MIN_VALUE;
                for(int j=i-1;j!=i;j=(j-1+n)%n){
                    if(a[j]>=max){
                        twomax = a[j];
                        twoway[i][j] = true;
                    }
                }
            }
            int ans = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(oneway[i][j]||twoway[i][j])
                        ans++;
                }
            }
            System.out.println(ans);
        }
    }
       
}