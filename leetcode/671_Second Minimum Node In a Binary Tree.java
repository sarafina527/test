/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        int ans = findFirstLarger(root,min);
        return ans;
    }
    public int findFirstLarger(TreeNode root,int min){
    	if(root==null)
    		return -1;
    	if(root.val>min)
    		return root.val;
    	else{
    		int l = findFirstLarger(root.left,min);
    		int r = findFirstLarger(root.right,min);
    		if(l==-1&&r==-1)
    			return -1;
    		else if(l==-1)
    			return r;
    		else if(r==-1)
    			return l;
    		else
    			return Math.min(l,r);
    	}

    }
}