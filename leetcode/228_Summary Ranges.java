public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> ans = new LinkedList<String>();
    	if(nums.length==0) return ans;
    	if(nums.length==1){
    		ans.add(""+nums[0]);
    		return ans;
    	}
    	int start = 0,i=1;
        for(;i<nums.length;i++){
        	if(nums[i]-nums[i-1]>1||i==nums.length-1){ 
        		String tmp;
        		if(start==i)
        			tmp = ""+i;
        		else       		
        		 	tmp = start+"->"+(i-1);
        		ans.add(tmp);
        		start = i;
        	}
        }
        if()
        return ans;
    }
}