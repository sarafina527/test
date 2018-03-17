class Solution {
    public int triangleNumber(int[] nums) {
        int[] lesscnt = new int[1001];
        int[] lessecnt = new int[1001];
        for(int e:nums){
        	for(int i=e;i<=1000;i++)
        		lessecnt[i]++;
        	for(int i=e+1;i<=1000;i++)
        		lesscnt[i]++;
        }
        //System.out.println(Arrays.toString(lesscnt));
        int ans = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0) continue;
        	for(int j=i+1;j<nums.length;j++){
        		if(nums[j]==0) continue;
        		int min = Math.abs(nums[i]-nums[j]);
        		int max = nums[i]+nums[j];
        		ans+=(lesscnt[max]-lessecnt[min]);
                if(nums[i]>min&&nums[i]<max) ans--;
                if(nums[j]>min&&nums[j]<max) ans--;
        	}
        }
        return ans/3;
    }
}