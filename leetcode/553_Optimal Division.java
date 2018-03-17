class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder ans = new StringBuilder();
        int n = nums.length;
        assert(nums.length>=1);
        ans.append(""+nums[0]);
        if(n==2){
            ans.append("/"+nums[1]);
        }else if(n>2){
            ans.append("/(");
            for(int i=1;i<n-1;i++){
                ans.append(nums[i]+"/");
            }
            ans.append(nums[n-1]+")");
        }
        return ans.toString();
    }
}
