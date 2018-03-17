class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] ans = new int[r][c];
        int m=nums.length;
        if(m==0) return nums;
        int n = nums[0].length;
        if(m*n!=r*c) return nums;
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		int index = i*n+j;
        		ans[index/c][index%c] = nums[i][j];
        	}
        }
        return ans;
    }
}