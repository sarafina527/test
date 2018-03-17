import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int par[] = new int[n];
            for(int i=0;i<n;i++) par[i] = -1;
            for(int i=0;i<n-1;i++){
                int pa = input.nextInt();
                int son = input.nextInt();
                par[son] = pa;
            }
            boolean[] visited = new boolean[n];
            int[] h = new int[n];
            int ans = 0;
            for(int i=0;i<n;i++){
                int hi = height(i,par,h,visited);
                if(hi>ans) ans = hi;
            }
            System.out.println(ans);
        }
    }
    public static int height(int i,int[] p,int[] h,boolean[] visited){
        if(p[i]==-1){
            visited[i] = true;
            h[i] = 1;
            return h[i];
        }
        if(visited[i]) return h[i];
        h[i] = 1+height(p[i],p,h,visited);
        visited[i] = true;
        return h[i];
    }
}