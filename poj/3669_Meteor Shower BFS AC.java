import java.util.*;
public class Main {  
    static int MaxN = 305;
    static int INF = 1<<30;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] board = new boolean[MaxN][MaxN];
    static boolean[][] terbo = new boolean[MaxN][MaxN];
    static int[][] d = new int[MaxN][MaxN];
    static Map<Integer,List<Point> > timePoints = new HashMap<Integer,List<Point> >();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        while(input.hasNext()){
            for(int i=0;i<MaxN;i++)
                for(int j=0;j<MaxN;j++){
                    board[i][j] = true;
                    terbo[i][j] = true;
                    d[i][j] = INF;
                }
                    
            int M = input.nextInt();
            int t0=INF,tm=0;
            for(int i=0;i<M;i++){
                int x = input.nextInt();
                int y = input.nextInt();
                int t = input.nextInt();
                bomb(x,y,terbo);
                if(!timePoints.containsKey(t)){
                    List<Point> points = new LinkedList<Point>();
                    points.add(new Point(x,y));
                    timePoints.put(t,points);
                }else{
                    timePoints.get(t).add(new Point(x,y));
                }
                if(x==0&&y==0||x==1&&y==0||x==0&&y==1){
                    if(t0>t) t0=t;
                }
                if(tm<t) tm = t;
            }
            if(t0==INF)
                System.out.println(0);
            else if(t0==0)
                System.out.println(-1);
            else{
                int ans = bfs(0,0,tm);
                System.out.println(ans);
            }
            
        }
    }
    public static int bfs(int x,int y,int tm){
        int m = MaxN,n=MaxN;
        LinkedList<Point> que = new LinkedList<Point>();
        que.offer(new Point(x,y));
        d[x][y] = 0;
        int t = 0;
        while(!que.isEmpty()&&t<=tm){
            Point cur = que.poll();
            t=d[cur.x][cur.y];
            if(timePoints.containsKey(t+1)){
                for(Point p:timePoints.get(t+1)){
                    bomb(p.x,p.y,board);
                }
            }
            for(int i=0;i<4;i++){
                int nx=cur.x+dx[i],ny=cur.y+dy[i];
                if(nx>=0&&nx<MaxN&&ny>=0&&ny<MaxN&&board[nx][ny]&&d[nx][ny]==INF){
                    que.offer(new Point(nx,ny));
                    d[nx][ny]=d[cur.x][cur.y]+1;
                    if(terbo[nx][ny])
                        return d[nx][ny];
                }
            }
        }
        return -1;        
    }
    public static void bomb(int x,int y,boolean[][] b){
        b[x][y] = false;
        for(int i=0;i<4;i++){
            int nx = x+dx[i],ny=y+dy[i];
            if(nx>=0&&nx<MaxN&&ny>=0&&ny<MaxN)
                b[nx][ny] = false;
        }
    }
    public static class Point{
        int x;int y;
        public Point(int i,int j){
            x = i;
            y = j;
        }
    }
}