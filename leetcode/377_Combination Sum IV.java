public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n/2;i++){
        	int t = nums[i];
        	nums[i] = nums[n-i-1];
        	nums[n-i-1] = t;
        }
        int[][] dp = new int[n+1][target+1];
        for(int i=0;i<n;i++)
            dp[i][0] = 1;
        dp[n][0] = 1;
        for(int i=n-1;i>=0;i--){
        	for(int j=1;j<=target;j++){
        		for(int c=0;c*nums[i]<=j;c++){
                    //System.out.println(i+" "+j+" "+c+" "+dp[i+1][j-c*nums[i]]);
                    dp[i][j] += dp[i+1][j-c*nums[i]];
                }
        			
        	}
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][target];
    }
}