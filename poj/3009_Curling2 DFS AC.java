import java.util.*;
public class Main {  
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while(input.hasNext()){
            int w = input.nextInt();
            int h = input.nextInt();
            if(w==0&&h==0) return;
            int[][] board = new int[h][w];
            int si=0,sj=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    board[i][j] = input.nextInt();
                    if(board[i][j]==2){
                        si=i;sj=j;
                    }
                }
            }
            boolean[][] visited = new boolean[h][w];
            int maxStep[] = new int[1];maxStep[0]=11;
            dfs(si,sj,0,board,maxStep);
            if(maxStep[0]==11) System.out.println(-1);
            else System.out.println(maxStep[0]);
        }
    }
    public static void dfs(int x,int y,int step,int[][] board,int[] maxStep){
        if(step>=maxStep[0]||board[x][y]==3) return;
        int m = board.length,n=board[0].length;
        step++;
        for(int i=0;i<4;i++){
            int nx=x+dx[i],ny=y+dy[i];
            if(!(nx>=0&&nx<m&&ny>=0&&ny<n)||board[nx][ny]==1) continue;
            while(nx>=0&&nx<m&&ny>=0&&ny<n&&board[nx][ny]!=1){
                if(board[nx][ny]==3){
                    if(maxStep[0]>step) maxStep[0] = step;
                    return;
                }
                nx+=dx[i];ny+=dy[i];
            }
            if(!(nx>=0&&nx<m&&ny>=0&&ny<n))//out of boundry
                continue;
            else if(board[nx][ny]==1){
                board[nx][ny] = 0;
                nx = nx-dx[i];ny=ny-dy[i];
                dfs(nx,ny,step,board,maxStep);
                board[nx+dx[i]][ny+dy[i]] = 1;
            }
        }
    }
}