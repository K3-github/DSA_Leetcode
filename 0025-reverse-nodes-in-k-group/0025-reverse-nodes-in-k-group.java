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
    private ListNode findKthNode(ListNode head,int k){
          ListNode ptr=head;
          while(k>1){
            ptr=ptr.next;
            k--;
            if(ptr==null) return null;
          }
          return ptr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
             ListNode kthNode=findKthNode(curr,k);
             if(kthNode==null){
                if(prev==null) return head;
                prev.next=curr;
                return head;
             }
             ListNode kthNodenext=kthNode.next;
             kthNode.next=null;
             rev(curr);
             if(curr==head){
                head=kthNode;
             }
             if(prev!=null) prev.next=kthNode;
             prev=curr;
             curr=kthNodenext;
        }
        return head;
    }
}