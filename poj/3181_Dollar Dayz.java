import java.util.*;
import java.math.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int k = input.nextInt();
            //滚动数组 多重背包
            BigInteger[][] dp = new BigInteger[2][n+1];
            for(int i=0;i<2;i++){
                for(int j=0;j<=n;j++)
                    dp[i][j] = BigInteger.ZERO;
            }
            dp[0][0] = BigInteger.ONE;//pre k dollar sums to n 
            for(int i=1;i<=k;i++){
                for(int j=0;j<=n;j++){
                    dp[i&1][j] = dp[(i-1)&1][j];
                    if(j>=i)
                        dp[i&1][j] = dp[i&1][j].add(dp[i&1][j-i]);
                }
            }
            System.out.println(dp[k&1][n]);
        }
    }
}