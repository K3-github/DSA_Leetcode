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
    private boolean solve(int ind,String s,int[] dp){
        if(ind>=s.length()) return true;
        if(dp[ind]!=-1) return dp[ind]==1;

        Node node=root;
        boolean ans=false;
        for(int j=ind;j<s.length();j++){
            char ch=s.charAt(j);
            node=node.links[ch-'a'];
            if(node==null) break;
            if(node.end==true){
                ans=ans || solve(j+1,s,dp);
            }
        }
        dp[ind]=(ans==false ? 0 : 1);
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
         for(int i=0;i<wordDict.size();i++){
            insert(wordDict.get(i));
         }
         int n=s.length();
         int[] dp=new int[n];
         Arrays.fill(dp,-1);
         return solve(0,s,dp);
    }
}