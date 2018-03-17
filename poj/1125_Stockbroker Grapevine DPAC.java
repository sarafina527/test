import java.util.*;
public class Main {
    static int max = 1<<10;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            if(n==0) return;
            int[][] dp = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++)
                    dp[i][j] = max;
                dp[i][i] = 0;
            }
            for(int i=1;i<=n;i++){
                int ecnt = input.nextInt();
                for(int j=0;j<ecnt;j++){
                    int to = input.nextInt();
                    dp[i][to] = input.nextInt();
                }
            }
            for(int k=1;k<=n;k++){
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=n;j++){
                        dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                    }
                }
            }
            int ans = Integer.MAX_VALUE;
            int start = 0;
            
            //System.out.println(Arrays.deepToString(dp));
            for(int i=1;i<=n;i++){
                int tmp = 0;
                for(int j=1;j<=n;j++){
                    tmp = Math.max(tmp,dp[i][j]);
                }
                if(tmp<ans){
                    ans = tmp;
                    start = i;
                }
            }
            if(ans>=max)
                System.out.println("disjoint");
            else
                System.out.println(start+" "+ans);
        }
    }
}