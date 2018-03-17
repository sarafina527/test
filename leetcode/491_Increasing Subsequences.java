public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        LinkedList<Integer> elem = new LinkedList<Integer>();
        dfs(0,elem,nums,ans);
        return new LinkedList<List<Integer>>(ans);

    }
    public void dfs(int i,LinkedList<Integer> sofar,int[] nums,Set<List<Integer>> ans){
    	if(i==nums.length){
    		if(sofar.size()>=2)
    			ans.add(new LinkedList<Integer>(sofar));
            return;
    	}
    	if(sofar.size()==0||sofar.getLast()<=nums[i]){
    		dfs(i+1,sofar,nums,ans);
			sofar.add(nums[i]);
    		dfs(i+1,sofar,nums,ans);
    		sofar.removeLast();    		
    	}else
    		dfs(i+1,sofar,nums,ans);
    }
}