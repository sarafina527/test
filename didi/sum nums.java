import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int sum = input.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = input.nextInt();
            }
            long[][] dp = new long[n+1][sum+1];
            for(int i=0;i<=n;i++)
                dp[i][0] = 1L;
            for(int i=0;i<n;i++){
                for(int j=1;j<=sum;j++){
                    if(j-a[i]>=0){
                        dp[i+1][j] = dp[i][j]+dp[i][j-a[i]];
                    }else
                        dp[i+1][j] = dp[i][j];
                }
            } 
            //System.out.println(Arrays.deepToString(dp));
            System.out.println(dp[n][sum]);
        }
    }
}