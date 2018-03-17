public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    	if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
    	int m=matrix.length,n=matrix[0].length;
        int low=matrix[0][0],high=matrix[m-1][n-1];
        while(low<high){
        	int mid = low+(high-low)/2;
        	int cnt = count(matrix,mid);
        	if(cnt<k)
        		low = mid+1;
        	else
        		high = mid;
        }
        return high;
    }
    public int count(int[][] matrix,int target){
    	int ans = 0;
    	int i=0,j=matrix[0].length-1;
    	while(i<matrix.length&&j>=0){
    		if(matrix[i][j]<=target){
    			ans+=j+1;
    			i++;
    		}else{
    			j--;
    		}
    	}
    	return ans;
    }
}