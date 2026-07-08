class Solution {
    HashSet<String> st=new HashSet<>();
    private int solve(int ind,String word,int[] dp){
        int n=word.length();
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int ans=Integer.MIN_VALUE;
        for(int j=ind;j<n;j++){
            String sub=word.substring(ind,j+1);
            if(st.contains(sub)){
                ans=Math.max(ans,1+solve(j+1,word,dp));
            }
        }
        return dp[ind]=ans;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for(String word: words){
            st.add(word);
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