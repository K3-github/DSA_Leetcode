class Node{
    Node[] links=new Node[26];
    boolean end=false;

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
        node.end=true;
    }
    private boolean search(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null) return false;
            node=node.links[ch-'a'];
            if(node.end==false) return false;
        }
        return node.end;
    }
    public String longestWord(String[] words) {
        Arrays.sort(words);
        for(String word: words){
            insert(word);
        }
        String ans="";
        for(String word: words){
            if(search(word)==true && ans.length()<word.length()){
                    ans=word;
            }
        }
        return ans;
    }
}