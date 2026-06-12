/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;

        ListNode odd=head,even=head.next;
        ListNode t1=odd,t2=even;
        ListNode curr=head.next.next;
        while(curr!=null){
            t1.next=curr;
            curr=curr.next;
            t2.next=curr;
            if(curr!=null) curr=curr.next;
            t1=t1.next;
            t2=t2.next;
        }
        t1.next=even;
        if(t2!=null) t2.next=null;
        return odd;
    }
}