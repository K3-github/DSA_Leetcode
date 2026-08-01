/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        if(root==null) return root;
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            Node st=q.poll();
            if(st.left!=null) q.offer(st.left);
            if(st.right!=null) q.offer(st.right);
            for(int i=1;i<size;i++){
               Node curr=q.poll();
               st.next=curr;
               st=curr;
               if(st.left!=null) q.offer(st.left);
               if(st.right!=null) q.offer(st.right);
            }
            st.next=null;
        }
        return root;
    }
}