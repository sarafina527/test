import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int p = input.nextInt();
            int[][] dp = new int[p+1][n+1];
            for(int i=0;i<=n;i++)
                dp[1][i] = 1;
            for(int i=2;i<=p;i++){
                for(int j=0;j<=n;j++){
                    if(i-1>=0) dp[i][j]+=dp[i-1][j];
                    if(j-1>=0) dp[i][j]+=dp[i][j-1];
                }
            }
            System.out.println(dp[p][n]);
        }
    }
       
}