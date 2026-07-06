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
    private boolean search(int ind,int edits,Node node,String word){
        int n=word.length();
        if(edits<0) return false;
        if(ind>=n) return node.end;

        char ch=word.charAt(ind);
        if(node.links[ch-'a']==null){
            if(edits==0) return false;
            for(int i=0;i<26;i++){
               if(node.links[i]!=null){
                    if(search(ind+1,edits-1,node.links[i],word)==true){
                            return true;
                    }
               }
            }
            return false;
        }
        else{
            boolean w1=search(ind+1,edits,node.links[ch-'a'],word);
            for(int i=0;i<26;i++){
               if(node.links[i]!=null){
                    if(search(ind+1,edits-1,node.links[i],word)==true){
                            return true;
                    }
               }
            }
            return w1;
        }
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        for(String word: dictionary){
            insert(word);
        }
        List<String> ans=new ArrayList<>();
        for(String q: queries){
            Node node=root;
            if(search(0,2,node,q)==true){
                ans.add(q);
            }
        }
        return ans;
    }
}