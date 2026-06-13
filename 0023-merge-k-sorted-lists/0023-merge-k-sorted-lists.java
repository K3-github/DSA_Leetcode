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
class Pair{
    int first;
    ListNode second;

    Pair(int first,ListNode second){
        this.first=first;
        this.second=second;
    }
}; 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.first - b.first);
        for(ListNode node : lists){
            if(node!=null) pq.offer(new Pair(node.val,node));
        }
        ListNode d=new ListNode(-1);
        ListNode curr=d;
        while(!pq.isEmpty()){
            Pair tp=pq.poll();
            curr.next=tp.second;
            curr=curr.next;
            if(tp.second.next!=null) pq.offer(new Pair(tp.second.next.val,tp.second.next));
        }
        return d.next;
    }
}