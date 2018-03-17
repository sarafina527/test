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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTreeFromIndex(nums,0,nums.length-1);
    }
    public TreeNode constructTreeFromIndex(int[] nums,int s,int e){
    	if(s>e) return null;
    	int maxindex = s;
    	for(int i=s;i<=e;i++){
        	if(nums[i]>nums[maxindex]){
        		maxindex = i;
        	}
        }
        TreeNode root = new TreeNode(nums[maxindex]);
        root.left = constructTreeFromIndex(nums,s,maxindex-1);
        root.right = constructTreeFromIndex(nums,maxindex+1,e);
        return root;
    }
}