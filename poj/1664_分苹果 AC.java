import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casenum = input.nextInt();
        while(casenum-->0){
            int m = input.nextInt();
            int n = input.nextInt();
            int[][][] dp = new int[m+1][n+1][m+1];

            for(int i=0;i<=m;i++){
                dp[i][1][i] = 1;
            }
            for(int i=0;i<=m;i++){
                for(int j=2;j<=n;j++){
                    for(int k=0;k<=m;k++){
                        for(int nk=0;nk<=k;nk++)
                            if(i>=k)
                                dp[i][j][k] +=dp[i-k][j-1][nk];
                    }
                }
            }
            int ans=0;
            for(int k=0;k<=m;k++){
                ans+=dp[m][n][k];
            }
            System.out.println(ans);
        }        
    }
}