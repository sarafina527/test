public class Solution {
    public void Mirror(TreeNode root) {
        if(root==null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}