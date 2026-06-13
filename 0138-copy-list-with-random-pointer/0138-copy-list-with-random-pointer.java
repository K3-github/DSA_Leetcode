/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node newHead=new Node(head.val);
        HashMap<Node,Node> mp=new HashMap<>();
        mp.put(head,newHead);
        Node curr=newHead;
        Node temp=head;
        while(temp!=null){
             if(mp.containsKey(temp.next)){
                 curr.next=mp.get(temp.next);
             }
             else{
                if(temp.next==null) curr.next=null;
                else{
                    Node node=new Node(temp.next.val);
                    curr.next=node;
                    mp.put(temp.next,node);
                }
             }

             if(mp.containsKey(temp.random)){
                curr.random=mp.get(temp.random);
             }
             else{
                if(temp.random==null) curr.random=null;
                else{
                    Node node=new Node(temp.random.val);
                    curr.random=node;
                    mp.put(temp.random,node);
                }
             }
             curr=curr.next;
             temp=temp.next;
        }
        return newHead;
    }
}