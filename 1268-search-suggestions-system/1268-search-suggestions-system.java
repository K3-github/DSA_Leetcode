class Node{
    Node[] links=new Node[26];
    PriorityQueue<String> pq=new PriorityQueue<>((a,b) -> a.compareTo(b));

    Node(){}
};
class Solution {
    private Node root=new Node();
    private void insert(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
            }
            node=node.links[ch-'a'];
            node.pq.offer(word);
        }
        return;
    }
    private List<String> search(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
            node=node.links[ch-'a'];
            if(node==null) return new ArrayList<>();
        }
        List<String> products=new ArrayList<>();
        int rem=3;
        while(node.pq.size()>0 && rem>0){
            products.add(node.pq.poll());
            rem--;
        }
        return products;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(String product: products){
            insert(product);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<searchWord.length();i++){
            String sub=searchWord.substring(0,i+1);
            ans.add(search(sub));
        }
        return ans;
    }
}