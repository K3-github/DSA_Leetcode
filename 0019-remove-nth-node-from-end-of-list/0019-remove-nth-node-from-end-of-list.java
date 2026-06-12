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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t2=head;
        while(n>0){
            t2=t2.next;
            n--;
        }
        ListNode prev=null;
        ListNode t1=head;
        while(t2!=null){
            prev=t1;
            t1=t1.next;
            t2=t2.next;
        }
        if(prev==null) return head.next;
        prev.next=t1.next;
        return head;
    }
}