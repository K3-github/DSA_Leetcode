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
    Node currPage;
    public BrowserHistory(String homepage) {
        currPage=new Node(homepage);
    }
    
    public void visit(String url) {
        currPage=currPage.addAtLast(url);
    }
    
    public String back(int steps) {
        while(currPage.prev!=null && steps>0){
            currPage=currPage.prev;
            steps--;
        }
        return currPage.data;
    }
    
    public String forward(int steps) {
        while(currPage.next!=null && steps>0){
            currPage=currPage.next;
            steps--;
        }
        return currPage.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */