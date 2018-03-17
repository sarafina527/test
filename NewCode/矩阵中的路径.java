public class Solution {
	private char[] matrix;
	private char[] str;
	private int rows,cols;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	this.matrix = matrix;this.str = str;this.rows=rows;this.cols=cols;
    	boolean[] visited = new boolean[matrix.length];
    	for(int i=0;i<matrix.length;i++){
    		if(matrix[i]==str[0]){
    			Arrays.fill(visited,false);
    			if(hasPath(0,i,visited))
    				return true;
    		}	
    	}
    	return false;
    }
    public boolean hasPath(int strcur,int mcur,boolean[] visited){
        if(strcur==str.length-1) return true;
    	visited[mcur] = true;
    	int[] dir = {-1,-cols,1,cols};
    	for(int i=0;i<dir.length;i++){
    		int next = mcur+dir[i];
    		if(next>=0&&next<matrix.length&&!visited[next]&&matrix[next]==str[strcur+1])
    			if(hasPath(strcur+1,next,visited))
    				return true;
    	}
    	return false;
    }
}