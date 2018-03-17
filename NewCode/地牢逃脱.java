import java.util.*;

public class Main{
    public static int INF = 1<<30;
    public static class Point{
        int x;int y;
        public Point(int i,int j){
            x = i;
            y = j;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int m = input.nextInt();
            int n = input.nextInt();
            char[][] board = new char[m][n];
            for(int i=0;i<m;i++){
                board[i] = input.next().toCharArray();
            }
            int x0 = input.nextInt(),y0 = input.nextInt();
            int k = input.nextInt();
            int[] dx = new int[k];int[] dy = new int[k];
            for(int i=0;i<k;i++){
                dx[i] = input.nextInt();
                dy[i] = input.nextInt();
            }
            boolean[][] visited = new boolean[m][n];
            int[][] d = new int[m][n];
            for(int i=0;i<m;i++)
                for(int j=0;j<n;j++)
                    d[i][j] = INF;
            bfs(x0,y0,d,board,dx,dy);
            int ans = 0;
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]=='.'&&ans<d[i][j])
                        ans = d[i][j];
                }
            }
            if(ans==INF) System.out.println(-1);
            else
                System.out.println(ans);            
        }
    }
    public static void bfs(int x,int y,int[][] d,char[][] board,int[] dx,int[] dy){
        int m = board.length,n=board[0].length;
        d[x][y] = 0;
        LinkedList<Point> que = new LinkedList<Point>();
        que.offer(new Point(x,y));
        while(!que.isEmpty()){
            Point curp = que.poll();
            for(int i=0;i<dx.length;i++){
                int nx = curp.x+dx[i],ny=curp.y+dy[i];
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&d[nx][ny]==INF&&board[nx][ny]=='.'){
                    que.offer(new Point(nx,ny));
                    d[nx][ny] = d[curp.x][curp.y]+1;
                }
            }
        }
    }
}
