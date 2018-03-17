class Solution {
    public int singleNonDuplicate(int[] nums) {
        int p = 0,q=nums.length-1;
        int mid =0;
        while(p<=q){
        	mid = p+(q-p)/2;
        	if(mid-1>=0&&nums[mid-1]==nums[mid]){
        		if((mid-1-p)%2==1){
        			q=mid-2;
        		}else{
        			p=mid+1;
        		}
        	}else if(mid+1<nums.length&&nums[mid+1]==nums[mid]){
        		if((mid-p)%2==1){
        			q=mid-1;
        		}else{
        			p=mid+2;
        		}
        	}else{
        		return nums[mid];
        	}
        }
        return nums[mid];
    }
}