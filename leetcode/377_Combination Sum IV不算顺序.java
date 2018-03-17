public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n/2;i++){
            int t = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = t;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<n;j++)
                if(i>=nums[j])
                    dp[i] += dp[i-nums[j]];
        }
        
        //System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}