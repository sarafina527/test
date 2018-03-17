public class Solution {
    public int maximalSquare(char[][] matrix) {
    	int m = matrix.length;
    	if(m<=0) return 0;
    	int n = matrix[0].length;
        int[][] len = new int[m][n];
        int ans = 0;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(matrix[i][j]=='0')
        			len[i][j] = 0;
        		else if(i==0||j==0)
        			len[i][j] = 1;
        		else 
        			len[i][j] = min(len[i-1][j],len[i][j-1],len[i-1][j-1])+1;
        		if(len[i][j]>ans) ans = len[i][j];
        	}
        }
        return ans*ans;
    }
    public int min(int a,int b,int c){
    	int ans = a<b?a:b;
    	if(c<ans) ans = c;
    	return ans;
    }
}