public class Solution {
    public void nextPermutation(int[] nums) {
    	int i=nums.length-1;
        for(;i>0;i--){
        	if(nums[i]>nums[i-1])
        		break;
        }

        if(i>0){
        	int j=i,q=j;
        	for(;j<nums.length;j++){
        		if(nums[j]>nums[i-1])
        			q=j;
        	}
            int tmp = nums[i-1];
            nums[i-1] = nums[q];
            nums[q] = tmp;
        }
        
        for(int j=nums.length-1,k=i;j>k;j--,k++){
        	int t = nums[k];
        	nums[k] = nums[j];
        	nums[j] = t;
        }
    }
}