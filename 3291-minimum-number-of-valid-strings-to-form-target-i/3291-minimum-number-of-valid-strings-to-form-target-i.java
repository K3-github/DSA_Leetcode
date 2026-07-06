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
    private int solve(int ind,String target,int[] dp){
        if(ind>=target.length()) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int ans=Integer.MAX_VALUE;
        Node node=root;
        for(int j=ind;j<target.length();j++){
            char ch=target.charAt(j);
            node=node.links[ch-'a'];
            if(node==null) break;
            int res=solve(j+1,target,dp);
            if(res!=Integer.MAX_VALUE) ans=Math.min(ans,1+res);
        }
        return dp[ind]=ans;
    }
    public int minValidStrings(String[] words, String target) {
        for(String word: words){
            insert(word);
        }
        int n=target.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=solve(0,target,dp);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}