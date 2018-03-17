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
    public int minDiffInBST(TreeNode root) {
        assert(root!=null);
        int ans = Integer.MAX_VALUE;
        if(root.left!=null){
            ans = Math.min(root.val-max(root.left),minDiffInBST(root.left));
        }
        if(root.right!=null){
            if(min(root.right)-root.val<ans)
                ans = min(root.right)-root.val;
            ans = Math.min(ans,minDiffInBST(root.right));
        }
        return ans;
    }
    public int min(TreeNode root){
        assert(root!=null);
        if(root.left!=null){
            return min(root.left);
        }else
            return root.val;
    }
    public int max(TreeNode root){
        assert(root!=null);
        if(root.right!=null)
            return max(root.right);
        else
            return root.val;
    }
}
