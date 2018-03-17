/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        recurPrint(listNode,ans);
        return ans;
    }
	public void recurPrint(ListNode listNode,ArrayList<Integer> ans){
		if(listNode==null) return;
		recurPrint(listNode);
		ans.add(listNode);
	}
}