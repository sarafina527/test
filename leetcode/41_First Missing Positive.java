public class Solution {
    public int firstMissingPositive(int[] nums) {

        for(int i=0;i<nums.length;i++){
        	while(nums[i]!=i+1){
                int sindex = nums[i]-1;
        		if(sindex<0||sindex>=nums.length)
        			break;
        		if(nums[i]==nums[sindex])
        			break;
        		int tmp = nums[i];
        		nums[i] = nums[sindex];
        		nums[sindex] = tmp;
        	}
        }
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=i+1)
        		return i+1;
        }
        return nums.length+1;
    }
}