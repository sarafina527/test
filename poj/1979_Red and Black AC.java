import java.util.*;
public class Main {    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int m = input.nextInt();
            if(m==0&&n==0) break;
            char[][] borad = new char[m][];
            int si=-1,sj=-1;
            for(int i=0;i<m;i++){
                String str = input.next();
                borad[i] = str.toCharArray();                
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++)
                    if(borad[i][j]=='@'){
                        si = i;sj=j;
                        break;
                    }
            }

            boolean[][] visited = new boolean[m][n];
            int[] ans = new int[1];ans[0] = 0;
            dfs(si,sj,borad,ans,visited);
            System.out.println(ans[0]);
            
        }
    }
    public static void dfs(int i,int j,char[][] borad,int[] ans,boolean[][] visited){
        ans[0]++;
        visited[i][j] = true;
        int m = borad.length,n=borad[0].length;
        int[] dx = {-1,0,1,0};int[] dy={0,-1,0,1};
        for(int k=0;k<4;k++){
            int adi = i+dx[k],adj = j+dy[k];
            if(adi>=0&&adi<m&&adj>=0&&adj<n&&!visited[adi][adj]&&borad[adi][adj]=='.')
                dfs(adi,adj,borad,ans,visited);
        }
    }
       
}