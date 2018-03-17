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
    public int kthSmallest(TreeNode root, int k) {
        int[] sofar = new int[1];
        sofar[0] = -1;
        int[] value = new int[1];
        kthSmallest(root,sofar,value,k);
        return value[0];
    }
    public boolean kthSmallest(TreeNode root,int[] sofar,int[] value,int k){
    	if(root==null&&sofar[0]<0){
            sofar[0] = 0;
    		return false;
        }else if(root!=null){
    		if(kthSmallest(root.left,sofar,value,k))
                return true;
    		sofar[0]++;
    		if(sofar[0]==k){
                value[0] = root.val;
                return true;
            }
    		if(kthSmallest(root.right,sofar,value,k))
                return true;
    	}
        return false;

    }
}