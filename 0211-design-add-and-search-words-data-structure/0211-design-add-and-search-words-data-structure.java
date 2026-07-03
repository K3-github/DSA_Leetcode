class Node{
    Node[] links=new Node[26];
    boolean flag=false;

    Node(){}
};
class WordDictionary {
    private static Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node=root;
        for(char ch: word.toCharArray()){
             if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
             }
             node=node.links[ch-'a'];
        }
        node.flag=true;
        return;
    }
    private boolean solve(Node node,String word,int ind){
        if(ind>=word.length()) return node.flag;
        char ch=word.charAt(ind);
        if(ch=='.'){
            boolean ans=false;
            for(int i=0;i<26;i++){
                if(node.links[i]!=null){
                   ans=ans || solve(node.links[i],word,ind+1);
                }
            }
            return ans;
        }
        if(node.links[ch-'a']==null) return false;
        return solve(node.links[ch-'a'],word,ind+1);
    }
    public boolean search(String word) {
        Node node=root;
        return solve(node,word,0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */