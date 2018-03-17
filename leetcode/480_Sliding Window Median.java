public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
    	double[] ans = new double[nums.length-k+1];
        int[] window = new int[k];
        for(int i=0;i<k;i++)
        	window[i] = nums[i];
        Arrays.sort(window);
        System.out.println(Arrays.toString(window));
        ans[0] = median(window);
        
        for(int i=1;i<=nums.length-k;i++){
        	int index = bsearch(window,nums[i-1]);
            //System.out.println(index);
        	window[index] = nums[i+k-1];
        	sortify(window,index);
            //System.out.println(Arrays.toString(window));
        	ans[i] = median(window);
            //System.out.println(ans[i]);
        }
        return ans;
    }
	public double median(int[] nums){
		int len = nums.length;
		if((len&1)!=0)
			return nums[len/2];
		else
			return (nums[len/2-1]/2.0+nums[len/2]/2.0);
	}
	public int bsearch(int[] nums,int target){
		int p=0,q=nums.length-1;		
		while(p<=q){
            int mid = p+(q-p)/2;
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]<target)
				p = mid+1;
			else
				q = mid-1;
		}
		return -1;
	}
	public void sortify(int[] nums,int index){
		int i = index;
		int v = nums[index];
		while(i>0&&v<nums[i-1]){//比前面的小            
			nums[i] = nums[i-1];
			i--;
		}
        if(i!=index){
            nums[i] = v;
            return;
        }		
		while(i<nums.length-1&&v>nums[i+1]){
			nums[i] = nums[i+1];
			i++;
		}
		nums[i] = v;
	}
}