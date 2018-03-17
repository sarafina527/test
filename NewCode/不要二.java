import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);    
        while(input.hasNext()){
            int w = input.nextInt();
            int h = input.nextInt();
            boolean[][] board = new boolean[w][h];
            int ans = dfs(board);
            System.out.println(ans);
        }
    }
    public static int dfs(boolean[][] board){
        int m=board.length,n=board[0].length;
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!board[i][j]&&(i-2<0||!board[i-2][j])&&(i+2>m||!board[i+2][j])&&(j-2<0||!board[i][j-2])&&(j+2>n||board[i][j+2])){
                    board[i][j] = true;
                    ans = Math.max(ans,1+dfs(board));
                    board[i][j] = false;
                }
            }
        }
        return ans;
    }
}