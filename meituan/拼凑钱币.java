import java.util.*;
public class Main {    
    static int[] coins = {1,5,10,20,50,100};
    static int cnt = 6;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            long[][] dp = new long[cnt+1][n+1];
            dp[0][0] = 1L;
            for(int i=0;i<cnt;i++){
                for(int j=0;j<=n;j++){
                    dp[i+1][j] += dp[i][j];
                    if(j>=coins[i])
                        dp[i+1][j] += dp[i+1][j-coins[i]];
                }
            }
            System.out.println(dp[cnt][n]);
        }
    } 
}