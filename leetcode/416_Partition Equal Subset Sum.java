public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0,n=nums.length;
        for(int i=0;i<n;i++)
        	sum+=nums[i];
        if((sum&1)!=0) return false;
        int w = sum/2;
        boolean[][] canp = new boolean[n+1][w+1];
        canp[n][0] = true;
        for(int i=n-1;i>=0;i--){
        	for(int j=0;j<=w;j++)
        		if(j>=nums[i])
        			canp[i][j] = canp[i+1][j]||canp[i+1][j-nums[i]];
        		else
        			canp[i][j] = canp[i+1][j];
        }
        return canp[0][w];
    }
}