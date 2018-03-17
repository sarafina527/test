public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
    	int m = matrix.length;
        if(m==0) return new int[0];
        int n = matrix[0].length;
    	int[] ans = new int[m*n];
        int i=0,j=0,cnt=0;
        boolean topdown = false;
        while(cnt<m*n){
            //System.out.println(matrix[i][j]);
        	ans[cnt++]=matrix[i][j];
        	if((i==0||j==n-1)&&!topdown){
        		topdown = true;
        		if(j+1<n) j++;
        		else i++;
        	}else if((j==0||i==m-1)&&topdown){
        		topdown = false;
        		if(i+1<m) i++;
        		else j++;
        	}else{
        		if(topdown){
        			i++;j--;
        		}else{
        			i--;j++;
        		}
        	}
        }
        return ans;
    }
}