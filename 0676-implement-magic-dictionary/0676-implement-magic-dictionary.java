class Node{
    Node[] links=new Node[26];
    boolean flag=false;

    Node(){}
};
class MagicDictionary {
    private static Node root;
    public MagicDictionary() {
       root=new Node(); 
    }
    
    public void buildDict(String[] dictionary) {
        for(String word: dictionary){
            Node node=root;
            for(char ch: word.toCharArray()){
                if(node.links[ch-'a']==null){
                    node.links[ch-'a']=new Node();
                }
                node=node.links[ch-'a'];
            }
            node.flag=true;
        }
        return;
    }
    private boolean solve(Node node,String word,int ind,int k){
        if(k<0) return false;
        if(ind>=word.length()){
            if(k>0) return false;
            return node.flag;
        }
        char ch=word.charAt(ind);
        
        if(node.links[ch-'a']==null){
            if(k==0) return false;
            boolean ans=false;
            for(int i=0;i<26;i++){
                if(node.links[i]!=null){
                   ans=ans || solve(node.links[i],word,ind+1,k-1);
                }
            }
            return ans;
        }
        else{
           boolean w1=solve(node.links[ch-'a'],word,ind+1,k);
            for(int i=0;i<26;i++){
                if(i == ch - 'a') continue;
                if(node.links[i]!=null){
                   w1=w1 || solve(node.links[i],word,ind+1,k-1);
                }
            }
            return w1;
        }
    }
    public boolean search(String searchWord) {
        Node node=root;
        return solve(node,searchWord,0,1);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */