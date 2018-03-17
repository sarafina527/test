public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
    	int m = matrix.length;
    	if(m==0) return 0;
    	int n = matrix[0].length,ans = 0;
        int[][] d = new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++)
        		if(d[i][j]==0)
        			dfs(i,j,matrix,d);
        }
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++)
        		if(ans<d[i][j])
        			ans = d[i][j];
        }
        return ans;
    }
    public void dfs(int i,int j,int[][] matrix,int[][] d){    	
    	if(d[i][j]!=0) return;
    	int cur = matrix[i][j];
    	d[i][j] = 1;
    	if(i-1>=0&&matrix[i-1][j]>cur){
    		dfs(i-1,j,matrix,d);
    		d[i][j] = Math.max(d[i][j],1+d[i-1][j]);
    	}
    	if(i+1<matrix.length&&matrix[i+1][j]>cur){
    		dfs(i+1,j,matrix,d);
    		d[i][j] = Math.max(d[i][j],1+d[i+1][j]);
    	}
    	if(j-1>=0&&matrix[i][j-1]>cur){
    		dfs(i,j-1,matrix,d);
    		d[i][j] = Math.max(d[i][j],1+d[i][j-1]);
    	}
    	if(j+1<matrix[0].length&&matrix[i][j+1]>cur){
    		dfs(i,j+1,matrix,d);
    		d[i][j] = Math.max(d[i][j],1+d[i][j+1]);
    	}    		
    }
}