public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        int[] pairsum = new int[n*n];
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++)
        		pairsum[i*n+j] = nums[i]+nums[j];
        }
        Arrays.sort(pairsum);
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		if(Arrays.bin)
        	}
        }
    }
}