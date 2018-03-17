import java.util.*;
public class Main {     
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int sum = input.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = input.nextInt();
            }
            long[][] dp = new long[n+1][sum+1];
            dp[n][0] = 1L;
            for(int i=n-1;i>=0;i--){
                for(int j=0;j<=sum;j++){
                    if(j>=nums[i])
                        dp[i][j] = dp[i+1][j]+dp[i+1][j-nums[i]];
                    else
                        dp[i][j] = dp[i+1][j];
                }

            }
            System.out.println(dp[0][sum]);           
        }      
    }
}