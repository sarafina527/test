/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
    	ListNode p = head;
    	head = null;
    	while(p!=null){
    		ListNode next = p.next;
    		p.next = head;
    		head = p;
    		p = next;
    	}
    	return head;
    }
}