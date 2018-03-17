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
        public Pair(int cost,int t){stow=cost;to=t;}
    }
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
            for(Edge e:graph[v]){
                int w = e.w;
                int u = e.to;
                if(d[v]!=INF&&d[u]>d[v]+w){
                    d[u] = d[v]+w;
                    que.offer(new Pair(d[u],u));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int A = input.nextInt();
            int B = input.nextInt();
            List<Edge>[] graph =(List<Edge>[])new List[n+1];
            graph[0] = new LinkedList<Edge>();
            for(int i=1;i<=n;i++){
                graph[i] = new LinkedList<Edge>();
                int degree = input.nextInt();
                int cost = 0;
                for(int j=0;j<degree;j++){
                    int to = input.nextInt();
                    graph[i].add(new Edge(to,cost++));
                }
            }
            int[] d = new int[n+1];
            dijkstra(d,graph,A);
            //System.out.println(Arrays.toString(d));
            if(d[B]==INF)
                System.out.println(-1);
            else
                System.out.println(d[B]);
        }
    }
}