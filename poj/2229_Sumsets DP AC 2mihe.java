import java.util.*;
public class Main {    
    static int mod = 1000000000;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int log2 = (int)(Math.log(n)/Math.log(2));
        int[][] dp = new int[log2+2][n+1];//pre i 2mi
        for(int i=0;i<=log2+1;i++) dp[i][0] = 1;
        for(int i=0;i<=log2;i++){
            int cur2 = 1<<i;
            for(int j=1;j<=n;j++){
                if(j>=cur2){
                    long tmp = ((long)dp[i][j]+dp[i+1][j-cur2])%mod;
                    dp[i+1][j] = (int) tmp;
                }
                else
                    dp[i+1][j] = dp[i][j];
            }
        }
        System.out.println(dp[log2+1][n]);
    }
}