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
}