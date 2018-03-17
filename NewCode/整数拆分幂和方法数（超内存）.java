import java.util.*;
public class Main {
    static int m = 1000000000; 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int log = log2(n);
            int[][] dp = new int[log+2][n+1];//j fen cheng pre i e 
            for(int j=1;j<=n;j++)
                dp[1][j] = 1;
            for(int i=1;i<=log;i++){
                int part = 1<<i;
                for(int j=1;j<=n;j++){
                    if(j>part)
                        dp[i+1][j] = (dp[i+1][j-part]+dp[i][j])%m;
                    else
                        dp[i+1][j] = dp[i][j];
                    /*for(int c=0;c*part<=j;c++)
                        dp[i+1][j] =(dp[i+1][j]+dp[i][j-c*part])%m;*/
                }
            }
            //System.out.println(Arrays.deepToString(dp));
            System.out.println(dp[log+1][n]);
        }
    }
    public static int log2(int n){
        int ans = 0;
        while(n>1){
            n>>=1;
            ans++;
        }
        return ans;
    }    
}