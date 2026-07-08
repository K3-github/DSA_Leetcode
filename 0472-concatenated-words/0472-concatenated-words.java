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
    private int solve(int ind,String word,int[] dp){
        int n=word.length();
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int ans=Integer.MIN_VALUE;
        Node node=root;
        StringBuilder sub=new StringBuilder();
        for(int j=ind;j<n;j++){
            char ch=word.charAt(j);
            node=node.links[ch-'a'];
            if(node==null) break;
            if(node.end==true){
                ans=Math.max(ans,1+solve(j+1,word,dp));
            }
        }
        return dp[ind]=ans;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for(String word: words){
            insert(word);
        }
        List<String> ans=new ArrayList<>();
        for(String word: words){
            int[] dp=new int[word.length()];
            Arrays.fill(dp,-1);
            int mxs=solve(0,word,dp);
            if(mxs>=2) ans.add(word);
        }
        return ans;
    }
}