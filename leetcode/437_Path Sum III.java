/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> table = new HashMap<Integer,Integer>();
        int[] ans = new int[1];
        pathSum(root,0,sum,ans,table);
        return ans[0];
    }
    public void pathSum(TreeNode root,int sofar,int sum,int[] ans,Map<Integer,Integer> table){
    	if(root==null) return;
    	else{
    		int pre = sofar-sum+root.val;
    		if(table.containsKey(pre)&&table.get(pre)>0)
    			ans[0]+=table.get(pre);
    		sofar+=root.val;
    		if(sofar==sum) ans[0]++;
    		if(table.containsKey(sofar))
    		    table.put(sofar,table.get(sofar)+1);
    		else
	    		table.put(sofar,1);
	    	pathSum(root.left,sofar,sum,ans,table);
	    	pathSum(root.right,sofar,sum,ans,table);
	    	table.put(sofar,table.get(sofar)-1);
    	}
    }
}