public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        LinkedList<Integer> one = new LinkedList<Integer>();
        dfs(1,k,n,one,ans);
        return ans;
    }
    public void dfs(int cur,int leftk,int leftn,LinkedList<Integer> sofar,List<List<Integer>> ans){
    	if(leftn==0&&leftk==0)
    		ans.add(new LinkedList(sofar));
    	else if(leftk>0&&leftn>0&&cur<=9){
    		sofar.add(cur);
    		dfs(cur+1,leftk-1,leftn-cur,sofar,ans);
    		sofar.removeLast();
    		dfs(cur+1,leftk,leftn,sofar,ans);
    	}
    }
}