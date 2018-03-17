import java.util.*;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(root==null) return ans;
        que.offer(root);
        while(!que.isEmpty()){
        	TreeNode cur = que.poll();
            ans.add(cur.val);
            if(cur.left!=null)
                que.add(cur.left);
            if(cur.right!=null)
                que.add(cur.right);            
        }
        return ans;
    }
}