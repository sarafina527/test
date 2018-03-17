import java.util.*;
public class Main {
    static int INF = 1<<30;
    static class Edge{
        int to;int w;
        public Edge(int t,int ww){
            to = t;w = ww;
        }
    }
    static class Pair{
        int stow;int to;
        public Pair(int w,int t){stow=w;to=t;}
    }
    //邻接矩阵
    public static void dijkstra(int[][] graph,int s,int[] d){
        int n = graph.length;
        Arrays.fill(d,INF);
        d[s] = 0;
        PriorityQueue<Pair> que = new PriorityQueue<Pair>(n,new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p1.stow - p2.stow;
            }
        });
        que.offer(new Pair(0,s));
        while(!que.isEmpty()){
            Pair cur = que.poll();
            int v = cur.to;
            if(d[v]<cur.stow) continue;
            for(int i=0;i<n;i++){
                if(d[i]>d[v]+graph[v][i]){
                    d[i] = d[v]+graph[v][i];
                    que.offer(new Pair(d[i],i));
                }
            }
        }
    }
    
    //邻接表 给定单源点 求到其他点的最短路径 节点从一编号
    public static void dijkstra(int[] d,List<Edge>[] graph,int s){
        int n = d.length-1;
        Arrays.fill(d,INF);
        d[s]=0;
        PriorityQueue<Pair> que = new PriorityQueue<Pair>(n,new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p1.stow - p2.stow;
            }
        });
        que.offer(new Pair(0,s));
        while(!que.isEmpty()){
            Pair cur = que.poll();
            int v = cur.to;
            if(d[v]<cur.stow) continue;
            for(Edge e:graph[v]{
                int w = e.w;
                int u = e.to;
                if(d[u]>d[v]+w){
                    d[u] = d[v]+w;
                    que.offer(new Pair(d[u],u));
                }
            }
        }
    }
    //邻接矩阵
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[][] graph = new int[n][n];
            graph[0][0] = 0;
            for(int i=1;i<n;i++){
                graph[i][i] = 0;
                for(int j=0;j<i;j++){
                    String str = input.next();
                    if(str.equals("x")){
                        graph[i][j] = INF;
                        graph[j][i] = INF;
                    }else{
                        graph[i][j] = Integer.parseInt(str);
                        graph[j][i] = graph[i][j];
                    }
                }
            }
            int[] d = new int[n];
            dijkstra(graph,0,d);
            int ans = 0;
            for(int i=0;i<n;i++){
                ans = Math.max(ans,d[i]);
            }
            System.out.println(ans);
        }
    }
    //邻接表
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            //构造邻接表
            //**注意双向边向边集中添加两次
            int m = input.nextInt();
            int x = input.nextInt();//源点
            List<Edge>[] graph =(List<Edge>[])new List[n+1];//邻接表
            Arrays.fill(graph,new LinkedList<Edge>());
            for(int i=0;i<m;i++){
                int s = input.nextInt();
                int t = input.nextInt();
                int ww = input.nextInt();
                graph[s].add(new Edge(t,ww));
            }
            int[] d = new int[n+1];//存放源点到各个点的最短路径
            dijkstra(d,edges,x);
        }
    }
}