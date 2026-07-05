class Node{
    Node[] links=new Node[26];
    int cnt=0;

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
            node.cnt++;
        }
    }
    private int getScore(String word){
        int ans=0;
        Node node=root;
        for(char ch: word.toCharArray()){
            node=node.links[ch-'a'];
            if(node==null) return 0;
            ans+=node.cnt;
        }
        return ans;
    }
    public int[] sumPrefixScores(String[] words) {
        int n=words.length;
        for(String word: words) insert(word);
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=getScore(words[i]);
        }
        return ans;
    }
}



