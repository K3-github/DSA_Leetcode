/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(fast==null) return null;
            fast=fast.next;
            if(slow==fast) break;
        }
        if(fast==null) return null;
        slow=head;
        while(true){
            if(slow==fast) return slow;
            slow=slow.next;
            fast=fast.next;
        }
    }
}