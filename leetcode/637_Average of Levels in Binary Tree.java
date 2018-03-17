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
    public List<Double> averageOfLevels(TreeNode root) {
    	List<Double> ans = new LinkedList<Double>();
        if(root==null) return ans;
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        Map<TreeNode,Integer> level = new HashMap<TreeNode,Integer>();
        level.put(root,0);
        que.offer(root);
        int prelevel = 0;
        long sum = 0;
        int cnt = 0;
        int i=0;
        while(!que.isEmpty()){
        	TreeNode cur = que.poll();
        	int curl = level.get(cur);
        	if(curl!=prelevel){
        		ans.add(sum*1.0/cnt);
        		sum = cur.val;
        		cnt = 1;
        		prelevel = curl;        		
        	}else{
        		sum += cur.val;
        		cnt++;
        	}
        	if(cur.left!=null){
        		level.put(cur.left,curl+1);
        		que.offer(cur.left);
        	}
        	if(cur.right!=null){
        		level.put(cur.right,curl+1);
        		que.offer(cur.right);
        	}
        }
        if(cnt!=0)
           ans.add(sum*1.0/cnt);
        return ans;
    }
    public int getHeight(TreeNode root){
    	if(root==null) return 0;
    	return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}