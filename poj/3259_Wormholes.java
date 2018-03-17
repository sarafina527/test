import java.util.*;
public class Main {
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
        int cases = input.nextInt();
        while(cases-->0){
            int n = input.nextInt();
            int m = input.nextInt();
            int w = input.nextInt();
            Edge[] edges = new Edge[2*m+w];
            for(int i=0,j=0;i<m;i++){
                int s = input.nextInt();
                int t = input.nextInt();
                int ww = input.nextInt();
                edges[j++] = new Edge(s,t,ww);//特别注意双向边 要加两次
                edges[j++] = new Edge(t,s,ww);
            }
            for(int j=2*m;j<2*m+w;j++){
                edges[j] = new Edge(input.nextInt(),input.nextInt(),-input.nextInt());
            }
            boolean ans = findNegLoop(n,2*m+w,edges);
            if(ans)
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
    }
    public static boolean findNegLoop(int V,int E,Edge[] edges){
        long[] d = new long[V+1];
        for(int i=1;i<=V;i++){
            for(int j=0;j<E;j++){
                Edge e = edges[j];
                if(d[e.to]>d[e.from]+e.w){
                    d[e.to] = d[e.from]+e.w;
                    if(i==V) return true;
                }  
            }
        }
        return false;
    }
}