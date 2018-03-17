import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ts = input.nextInt();
        int w = input.nextInt();
        int[] t = new int[ts];
        for(int i=0;i<ts;i++) t[i] = input.nextInt();
        int[][][] dp = new int[ts+1][w+1][2];
        if(t[0]==1) dp[1][0][0] = 1;
        else if(w>=1) dp[1][1][1] = 1;
        for(int i=1;i<ts;i++){
            for(int j=0;j<=w;j++){
                if(t[i]==1){
                    dp[i+1][j][0] = Math.max(dp[i][j][0],j>=1?dp[i][j-1][1]:-1)+1;
                    dp[i+1][j][1] = Math.max(dp[i][j][1],j>=1?dp[i][j-1][0]:0);
                }else{
                    dp[i+1][j][0] = Math.max(dp[i][j][0],j>=1?dp[i][j-1][1]:0);
                    dp[i+1][j][1] = Math.max(dp[i][j][1],j>=1?dp[i][j-1][0]:-1)+1;
                }  
            }
        }
        System.out.println(Math.max(dp[ts][w][0],dp[ts][w][1]));
    }
}