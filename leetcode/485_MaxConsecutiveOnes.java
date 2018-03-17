public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        boolean flag = true;//前面是1
        int curcnt = 0;
        for(int i=0;i<nums.length;i++){
        	if(flag){
        		if(nums[i]==0){
        			if(curcnt>ans) ans = curcnt;
	        		flag = false;
	        		curcnt = 0;
        		}else{
        			curcnt++;
        		}
        	}else{
        		if(nums[i]==1){
        			flag = true;
        			curcnt++;
        		}
        	}
        }
        if(curcnt>ans) ans=curcnt;
        return ans;
    }
}