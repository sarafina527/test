/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right!=null){
            return getMin(pNode.right);
        }else{
            TreeLinkNode lec = pNode;
            while(lec.next!=null&&lec!=lec.next.left){
                lec = lec.next;
            }
            if(lec.next==null)
                return null;
            else{
                return lec.next;
            }
        }
    }
    public TreeLinkNode getMin(TreeLinkNode pNode){
        while(pNode.left!=null)
            pNode = pNode.left;
        return pNode;
    }
}