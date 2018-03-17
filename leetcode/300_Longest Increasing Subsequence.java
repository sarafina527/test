public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] d = new int[nums.length];
        for(int i=0;i<d.length;i++)
        	d[i] = 1;
        for(int i=1;i<d.length;i++){
        	for(int j=0;j<i;j++){
        		if(nums[j]<nums[i])
        			d[i] = Math.max(d[i],d[j]+1);
        	}
        }
        int ans = 0;
        for(int i=0;i<d.length;i++){
        	if(d[i]>ans)
        		ans = d[i];
        }
        return ans;
    }
}