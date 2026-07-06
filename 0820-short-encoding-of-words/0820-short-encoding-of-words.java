class Node{
    Node[] links=new Node[26];

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
        }
    }
    private boolean search(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
            node=node.links[ch-'a'];
            if(node==null) return false;
        }
        return true;
    }
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a,b)-> b.length() - a.length());
        int ans=0;
        for(String word: words){
            String rev = new StringBuilder(word).reverse().toString();
            if(search(rev)==true) continue;
            insert(rev);
            ans+=word.length()+1;
        }
        return ans;
    }
}