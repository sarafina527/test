import java.util.ArrayList;
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;

    }
}
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sofar = new ArrayList<Integer>();
        if(root==null) return ans;
        findPath(root,0,sofar,ans,target);
        return ans;
    }
    public void findPath(TreeNode cur,int sum,ArrayList<Integer> sofar,ArrayList<ArrayList<Integer>> ans,int target){
        if(cur==null) return;
        sofar.add(cur.val);
        sum +=cur.val;
        if(cur.left==null&&cur.right==null){//leaf
            if(sum==target){
                ArrayList<Integer> copy = new ArrayList<Integer>();
                for(int i:sofar)
                    copy.add(i);
                ans.add(copy);
            }
        }else{//non leaf
            if(cur.left!=null)
                findPath(cur.left,sum,sofar,ans,target);
            if(cur.right!=null)
                findPath(cur.right,sum,sofar,ans,target);
        }
        sofar.remove(sofar.size()-1);
    }
}