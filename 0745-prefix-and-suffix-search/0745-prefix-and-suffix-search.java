class Node{
    HashMap<Character,Node> links=new HashMap<>();
    int ind=-1;
    
    Node(){}
};
class WordFilter {
    private Node root=new Node();
    private void insert(String word,int ind){
        Node node=root;
        for(char ch: word.toCharArray()){
            if(!node.links.containsKey(ch)){
                node.links.put(ch,new Node());
            }
            node=node.links.get(ch);
            node.ind=ind;
        }
    }
    private int search(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
            node=node.links.get(ch);
            if(node==null) return -1;
        }
        return node.ind;
    }
    public WordFilter(String[] words) {
        for(int index=0;index<words.length;index++){
            for(int i=0;i<words[index].length();i++){
                String suff=words[index].substring(i);
                String key=suff+"#"+words[index];
                insert(key,index);
            }
        }
    }
    
    public int f(String pref, String suff) {
        String key=suff+"#"+pref;
        return search(key);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */