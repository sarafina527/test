import java.util.*;
public class Main {  
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,-1,1,0};
    static class pair{
        int x;int y;
        pair(int i,int j){ x=i;y=j;}
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int m = input.nextInt();
            int n = input.nextInt();
            int max = input.nextInt();
            int[][] board = new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++)
                    board[i][j] = input.nextInt();
            }
            int ans = 0;
            pair[][] from = new pair[m][n];
            pair s = new pair(0,0);
            if(!bfs(s,board,max,from))
                System.out.println("Can not escape!"); 
            else{
                LinkedList<pair> p = new LinkedList<pair>();
                int x=0,y=n-1;
                while(!(x==0&&y==0)){
                    pair pi = from[x][y];
                    p.add(pi);
                    x=pi.x;y=pi.y;
                }
                Iterator<pair> it = p.descendingIterator();
                while(it.hasNext()){
                    pair pi = it.next();
                    System.out.print("["+pi.x+","+pi.y+"],");
                }
                System.out.println("[0,"+(n-1)+"]");
            }           
        }      
    }
    public static boolean bfs(pair s,int[][] board,int max,pair[][] from){
        int m = board.length,n=board[0].length;
        LinkedList<pair> que = new LinkedList<pair>();
        int d[][] = new int[m][n];
        que.offer(s);
        board[s.x][s.y] = -1;
        d[s.x][s.y] = 1;
        while(!que.isEmpty()){
            pair p = que.poll();
            if(p.x==0&&p.y==n-1&&d[p.x][p.y]<max)
                return true;
            if(d[p.x][p.y]>=max) return false;
            
            for(int i=0;i<4;i++){
                int nx=dx[i]+p.x,ny=dy[i]+p.y;
                if(nx>=0&&nx<m&&ny>=0&&ny<n&&board[nx][ny]==1){
                    board[nx][ny] = -1;
                    from[nx][ny] = p;
                    d[nx][ny] = 1+d[p.x][p.y];
                    que.add(new pair(nx,ny));
                }                    
            }
        }
        return false;
    }
   
}