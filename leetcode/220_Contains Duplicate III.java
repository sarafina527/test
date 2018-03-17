class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n=nums.length;
        if(n==0) return false;
        long kmin=kmax=nums[0];
        for(int i=1;i<n&&i<k;i++){
        	if(kmax<nums[i])
        		kmax = nums[i];
        	if(kmin>nums[i])
        		kmin = nums[i];
        }
        if(Math.abs(kmax-kmin)<=t) return true;
        for(int i=k;i<n;i++){
        	if(kmax<nums[i])
        }
        return false;
    }
}