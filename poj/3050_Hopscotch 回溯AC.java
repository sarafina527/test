import java.util.*;
public class Main {  
    static int n = 5;
    static int maxhop = 5;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static String[][] grid = new String[n][n];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    grid[i][j] = input.next();
            }
            Set<Integer> ans = new HashSet<Integer>();
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dfs(i,j,sb,ans,0);
                }
            }
            System.out.println(ans.size());
        }
    }
    public static void dfs(int x,int y,StringBuilder sofar,Set<Integer> ans,int step){
        if(step>5){
            int cur = Integer.parseInt(sofar.toString());
            if(!ans.contains(cur))
                ans.add(cur);
            return;
        }
        step++;
        for(int i=0;i<4;i++){
            int nx = x+dx[i],ny=y+dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<n){
                int len = sofar.length();
                sofar.append(grid[nx][ny]);
                dfs(nx,ny,sofar,ans,step);
                sofar.delete(len,sofar.length());
            }
        }
    }
       
}