public class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        int[][] visited = new int[rows][cols];
        int ans = 0;
        dfs(0,0,threshold,visited,rows,cols);
        for(int i=0;i<rows;i++){
        	for(int j=0;j<cols;j++){
        		if(visited[i][j]==1)
        			ans++;
        	}
        }
        return ans;
    }
    public void dfs(int i,int j,int threshold,int[][] visited,int rows,int cols){
    	if(digitsum(i,j)>threshold){
    		visited[i][j]=-1;
    		return;
    	}
    	visited[i][j] = 1;
    	int[] dr = {0,-1,0,1};int[] dc={-1,0,1,0};
    	for(int d=0;d<4;d++){
    		int adi=i+dr[d],adj=j+dc[d];
    		if(adi>=0&&adi<rows&&adj>=0&&adj<cols&&visited[adi][adj]==0){
    			dfs(adi,adj,threshold,visited,rows,cols);
    		}
    	}
    }
    public int digitsum(int i,int j){
    	int ans = 0;
    	while(i>0){
    		ans+=i%10;
    		i/=10;
    	}
    	while(j>0){
    		ans+=j%10;
    		j/=10;
    	}
    	return ans;
    }
}