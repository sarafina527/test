import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] board = new int[n][];
        int[][] dp = new int[n][];
        for(int i=0;i<n;i++){
            board[i] = new int[i+1];
            dp[i] = new int[i+1];
            for(int j=0;j<board[i].length;j++){
                board[i][j] = input.nextInt();
            }
        }
        for(int j=0;j<board[n-1].length;j++)
            dp[n-1][j] = board[n-1][j];
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1])+board[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }
}