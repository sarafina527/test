public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return new int[0][0];
        int m = matrix.length,n = matrix[0].length;
        int[][] d = new int[m][n];
        int[][] visited = new int[m][n];
        for(int i=0;i<m;i++){//init
            for(int j=0;j<n;j++)
                d[i][j] = m*n;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                if(visited[i][j]==0)
                    dfs(i,j,matrix,d,visited);
        }
        return d;

    }
    public void dfs(int i,int j,int[][] matrix,int[][] d,int[][] visited){
        if(matrix[i][j]==0){
            d[i][j] = 0;
            visited[i][j] = 1;
        }
        int m = matrix.length,n=matrix[0].length;
        visited[i][j] = -1;//visiting

        if(j-1>=0){//left
            if(visited[i][j-1]==0) dfs(i,j-1,matrix,d,visited);
            d[i][j] = Math.min(d[i][j],1+d[i][j-1]);
        }
        if(i-1>=0){//top
            if(visited[i-1][j]==0) dfs(i-1,j,matrix,d,visited);
            d[i][j]=Math.min(d[i][j],1+d[i-1][j]);           
        } 
        if(i+1<m){//down
            if(visited[i+1][j]==0) dfs(i+1,j,matrix,d,visited);
            d[i][j]=Math.min(d[i][j],1+d[i+1][j]);
        }
        if(j+1<n){//right
            if(visited[i][j+1]==0) dfs(i,j+1,matrix,d,visited);
            d[i][j]=Math.min(d[i][j],1+d[i][j+1]);
        }
        visited[i][j] = 1;
    }
}