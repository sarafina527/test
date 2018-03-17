import java.util.*;
public class Main {
    static int max = 1<<10;
    static class Edge{
        int from;
        int to;
        int w;
        public Edge(int s,int t,int ww){
            from = s;
            to = t;
            w = ww;
        }
    }
    //给定单源点 求到其他点的最短路径
    public static void ShortestPath(int[] d,Edge[] edges,int s){
        Arrays.fill(d,INF);
        d[s]=0;
        int V = d.length-1,E = edges.length;
        boolean update = false;
        while(true){
            update = false;
            for(Edge e:edges){
                if(d[e.from]!=INF&&d[e.to]>d[e.from]+e.w){
                    d[e.to] = d[e.from]+e.w;
                    update = true;
                }  
            }
            if(!update) return;
        }
    }

    //找负环 找负圈
    public static boolean findNegLoop(int V,int E,Edge[] edges){
        int[] d = new int[V+1];
        for(int i=1;i<=V;i++){
            for(int j=0;j<E;j++){
                Edge e = edges[j];
                if(d[e.to]>d[e.from]+e.w){
                    d[e.to] = d[e.from]+e.w;
                    if(i==V) return true;//如果第V次更新了，则一定存在负圈
                }  
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            //构造边集 
            //**注意双向边向边集中添加两次
            int m = input.nextInt();
            int x = input.nextInt();//源点
            Edge[] edges = new Edge[m];
            for(int i=0;i<m;i++){
                int s = input.nextInt();
                int t = input.nextInt();
                int ww = input.nextInt();
                edges[i] = new Edge(s,t,ww);
            }
            int[] d = new int[n+1];//存放源点到各个点的最短路径
            ShortestPath(d,edges,x);
        }
    }
}