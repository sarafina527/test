import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[][] board = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    board[i][j] = input.nextInt();
            }
            int[][] vsum = new int[n][n];
            preprocess(board,vsum);
            int ans = Integer.MIN_VALUE;
            int[] subvsum = new int[n];
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    for(int c=0;c<n;c++){
                        subvsum[c] = vsum[j][c];
                        if(i>0) subvsum[c]-=vsum[i-1][c];
                    }
                    ans = Math.max(ans,maxSubSum(subvsum));   
                }
            }
            System.out.println(ans);
        }
    }
    public static void preprocess(int[][] board,int[][] vsum){
        int n = board.length;
        for(int j=0;j<n;j++){
            vsum[0][j] = board[0][j];
            for(int i=1;i<n;i++){
                vsum[i][j] = board[i][j]+vsum[i-1][j];
            }
        }
    }
    public static int maxSubSum(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int ans = dp[0];
        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(arr[i],arr[i]+dp[i-1]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}