/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	if(pre==null||in==null||pre.length!=in.length||pre.length==0) return null;
        return reConBTRecur(0,0,pre.length,pre,in);
    }
    public TreeNode reConBTRecur(int pres,int ins,int len,int[] pre,int[] in){
    	int rv = pre[pres];
    	int i=ins;
    	for(;i<ins+len;i++){
    		if(rv==in[i])
    			break;
    	}
        int leftlen = i-ins,rightlen=len-i+ins-1;
        
    	TreeNode root = new TreeNode(rv);
        if(leftlen>0)
    		root.left = reConBTRecur(pres+1,ins,leftlen,pre,in);//注意不能写0
        if(rightlen>0)
    		root.right = reConBTRecur(pres+i-ins+1,i+1,rightlen,pre,in);
    	return root;
    }
}