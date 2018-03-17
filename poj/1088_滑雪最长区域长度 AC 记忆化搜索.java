import java.util.*;
public class Main {
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int r = input.nextInt();
            int c = input.nextInt();
            int[][] board = new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++)
                    board[i][j] = input.nextInt();
            }
            int[][] dp = new int[r][c];
            int ans = 0;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    ans=Math.max(ans,maxLength(i,j,board,dp));
                }
            }
            System.out.println(ans);
        }
    }
    public static int maxLength(int x,int y,int[][] board,int[][] dp){
        if(dp[x][y]>0) return dp[x][y];
        int cur = 1,r=board.length,c=board[0].length;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0&&nx<r&&ny>=0&&ny<c&&board[nx][ny]<board[x][y]){
                cur = Math.max(cur,maxLength(nx,ny,board,dp)+1);
            }
        }
        return dp[x][y]= cur;
    }
}