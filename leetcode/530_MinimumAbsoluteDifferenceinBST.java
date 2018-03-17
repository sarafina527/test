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
    public int getMinimumDifference(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        TreeNode[] pre = new TreeNode[1];
        inorder(root,pre,ans);
        return ans[0];
    }
    public void inorder(TreeNode root,TreeNode[] pre,int[] ans){
    	if(root!=null){
    		inorder(root.left,pre,ans);
    		if(pre[0]==null){
    			pre[0] = root;
    		}else{
    			int diff = root.val>pre[0].val?root.val-pre[0].val:pre[0].val-root.val;
    			if(ans[0]>diff) ans[0] = diff;
    			pre[0] = root;
    		}
    		inorder(root.right,pre,ans);
    	}
    }
}