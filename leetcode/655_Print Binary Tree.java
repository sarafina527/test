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
    public List<List<String>> printTree(TreeNode root) {
        int h = getHight(root);
        int c = (1<<h)-1;
        String[][] mat = new String[h][c];
        fill(root,0,c/2,h,c,mat);
        List<List<String>> ans = new ArrayList<List<String>>();
        //init
        for(int i=0;i<h;i++){
            ArrayList<String> row = new ArrayList<String>(c);
            for(int j=0;j<c;j++){
                if(mat[i][j]==null)
                    row.add("");
                else
                    row.add(mat[i][j]);
            }
            ans.add(row);
        }
        return ans;

    }
    public int getHight(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(getHight(root.left),getHight(root.right));
    }
    public void fill(TreeNode root,int i,int j,int h,int c,String[][] mat){
        if(i>=h||j<0||j>=c||root==null) return;
        mat[i][j] = ""+root.val;
        if(root.left!=null)
            fill(root.left,i+1,j-(1<<(h-i-2)),h,c,mat);
        if(root.right!=null)
            fill(root.right,i+1,j+(1<<(h-i-2)),h,c,mat);

    }
}