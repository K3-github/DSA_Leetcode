class Node{
    Node[] links=new Node[26];
    int ind=-1;
    int len=5002;

    Node(){}
};
class Solution {
    private Node root=new Node();
    private void insert(String word,int len,int ind){
        Node node=root;
        if(len < root.len){
            root.len = len;
            root.ind = ind;
        }
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
            }
            node=node.links[ch-'a'];
            if(len<node.len){
                node.len=len;
                node.ind=ind;
            }
        }
    }
    private int find(String word){
        Node node=root;
        int ans=root.ind;
        for(char ch: word.toCharArray()){
            node=node.links[ch-'a'];
            if(node==null) return ans;
            ans=node.ind;
        }
        return ans;
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        for(int i=0;i<wordsContainer.length;i++){
            String rev= new StringBuilder(wordsContainer[i]).reverse().toString();
            insert(rev,wordsContainer[i].length(),i);
        }
        int n=wordsQuery.length;
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            String rev= new StringBuilder(wordsQuery[i]).reverse().toString();
            answer[i]=find(rev);
        }
        return answer;
    }
}