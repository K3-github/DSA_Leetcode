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
    private ListNode mergeTwoSortedList(ListNode head1,ListNode head2){
        if(head1==null) return head2;
        if(head2==null) return head1;
        ListNode l1=head1,l2=head2;
        if(head1.val>head2.val){
            l1=head2;l2=head1;
        }
        while(l1!=null){
            ListNode prev=l1;
            while(l1!=null && l1.val<=l2.val){
                prev=l1; l1=l1.next;
            }
            prev.next=l2;
            if(l1!=null){
                ListNode t=l1;
                l1=l2;
                l2=t;
            }
        }
        return head1.val<=head2.val ? head1 : head2;
    }
    private ListNode solve(int ind,ListNode[] lists){
        if(ind<0) return null;

        ListNode newListNode=solve(ind-1,lists);
        return mergeTwoSortedList(lists[ind],newListNode);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        return solve(n-1,lists);
    }
}