import java.util.*;
public class Main {
    static class pair implements Comparable<pair>{
        int i;int j;
        int dist;
        public pair(int ii,int jj,int d){
            i = ii;j=jj;
            dist = d;
        }
        public int compareTo(pair p){
            return dist-p.dist;
        }
        public boolean equals(Object o){
            pair p = (pair) o;
            return (i==p.i)&&(j==p.j);
        }

    }    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int i=0;i<n;i++)
                x[i] = input.nextInt();
            for(int i=0;i<n;i++)
                y[i] = input.nextInt();
            //int[][] dist = new int[n][n];
            Set<pair> edges = new TreeSet<pair>();
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    int d = Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
                    edges.add(new pair(i,j,d));
                }
            }
            int[] ans = new int[n];
            ans[0] = 0;
            Set<Integer> vis = new HashSet<Integer>();
            int i= 1;
            for(pair p:edges){
                int pi = p.i,pj=p.j;
                if(vis.contains(pi)&&vis.contains(pj))
                    continue;
                ans[i] = p.dist+ans[i-1];
                vis.add(pi);vis.add(pj);
                if(++i==n) break;
            }
            for(int k=0;k<n-1;k++){
                System.out.print(ans[k]+" ");
            }
            System.out.println(ans[n-1]);
        }
    }
       
}