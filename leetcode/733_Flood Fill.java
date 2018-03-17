class Solution {
	int[] dx = {-1,1,0,0};
	int[] dy = {0,0,-1,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	int m = image.length;
    	if(m==0) return image;
    	int n = image[0].length;
    	boolean[][] visited = new boolean[m][n];
        int oldColor = image[sr][sc];
        dfs(image,sr,sc,oldColor,newColor,visited);
        return image;
    }
    public void dfs(int[][] image,int r,int c,int oldColor,int newColor,boolean[][] visited){    	
    	image[r][c] = newColor;
    	visited[r][c] = true;
    	for(int i=0;i<4;i++){
            int nr = r+dx[i];
            int nc = c+dy[i];
            if(nr>=0&&nc>=0&&nr<image.length&&nc<image[0].length&&image[nr][nc]==oldColor&&!visited[nr][nc]){
                dfs(image,nr,nc,oldColor,newColor,visited);
            }
    		    
        }
    }
} 