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
    private ListNode rev(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode newHead=rev(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int len=0;
        ListNode ptr=head;
        while(ptr!=null){
            len++;
            ptr=ptr.next;
        }
        k=k%len;
        if(k==0) return head;
        ListNode curr=head,prev=null;
        k=len-k;
        while(k-->0){
             prev=curr;
             curr=curr.next;
        }
        prev.next=null;
        ListNode node1=rev(head);
        ListNode node2=rev(curr);
        head.next=node2;
        return rev(node1);
    }
}