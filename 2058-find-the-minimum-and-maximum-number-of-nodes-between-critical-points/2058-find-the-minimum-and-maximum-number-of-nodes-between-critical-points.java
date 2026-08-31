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
    private boolean isCritical(ListNode prev,ListNode curr,ListNode next){
        if(curr.val<prev.val && curr.val<next.val) return true;
        if(curr.val>prev.val && curr.val>next.val) return true;
        return false;
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         ListNode prev=null,curr=head,next=null;
         int ind=0;
         List<Integer> cpt=new ArrayList<>();
         while(curr!=null){
            next=curr.next;
            if(prev!=null && next!=null){
                if(isCritical(prev,curr,next)) cpt.add(ind);
            }
            ind++;
            prev=curr;
            curr=curr.next;
         }
         int sz=cpt.size();
         if(sz<2) return new int[]{-1,-1};
         int mnDis=1000000,mxDis=cpt.get(sz-1)-cpt.get(0);
         for(int i=1;i<cpt.size();i++){
            mnDis=Math.min(mnDis,cpt.get(i)-cpt.get(i-1));
         }
         return new int[]{mnDis,mxDis};
    }
}