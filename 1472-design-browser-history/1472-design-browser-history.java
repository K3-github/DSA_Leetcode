class Node{
    String data;
    Node next;
    Node prev;

    Node(String data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }

    Node addAtLast(String data){
         if(this==null) return new Node(data);

         Node node=new Node(data);
         this.next=node;
         node.prev=this;
         return node;
    }
};
class BrowserHistory {
    Node head,curr;
    public BrowserHistory(String homepage) {
        head=new Node(homepage);
        curr=head;
    }
    
    public void visit(String url) {
        curr=curr.addAtLast(url);
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps>0){
            curr=curr.prev;
            steps--;
        }
        return curr.data;
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps>0){
            curr=curr.next;
            steps--;
        }
        return curr.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */