import java.util.*;
public class Main {
    static int INF = 10000000;
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        int n = input.nextInt();
        int m = input.nextInt();
        int x = input.nextInt();
        Edge[] edges = new Edge[m];
        for(int i=0;i<m;i++){
            int s = input.nextInt();
            int t = input.nextInt();
            int ww = input.nextInt();
            edges[i] = new Edge(s,t,ww);
        }
        int[] d = new int[n+1];
        int[] rd = new int[n+1];
        ShortestPath(rd,edges,x);
        for(Edge e:edges){
            int tmp = e.from;
            e.from = e.to;
            e.to = tmp;
        }
        ShortestPath(d,edges,x);
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(d[i]+rd[i]>ans)
                ans = d[i]+rd[i];
        }
        System.out.println(ans);        
    }
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
}