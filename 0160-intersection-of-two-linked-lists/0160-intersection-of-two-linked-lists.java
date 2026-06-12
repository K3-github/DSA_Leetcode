/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1=headA,l2=headB;
        while(l1!=null || l2!=null){
            if(l1==l2) return l1;
            l1=(l1==null ? headB : l1.next);
            l2=(l2==null ? headA : l2.next);
        }
        return null;
    }
}