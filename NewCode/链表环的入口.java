/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null||pHead.next==null) return null;
        ListNode fast=pHead.next.next,slow = pHead.next;
        while(fast!=slow){
            if(slow.next==null||fast==null||fast.next==null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = pHead;
        while(fast!=slow){
            if(fast==null||slow==null) return null;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}