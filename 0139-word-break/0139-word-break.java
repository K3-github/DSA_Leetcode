class Solution {
    HashSet<String> st=new HashSet<>();
    private int solve(int ind,String s,int[] dp){
        if(ind>=s.length()) return 1;
        if(dp[ind]!=-1) return dp[ind];

        int ans=0;
        for(int j=ind;j<s.length();j++){
            String str=s.substring(ind,j+1);
            if(st.contains(str)){
                if(solve(j+1,s,dp)==1) ans=1;
            }
        }
        return dp[ind]=ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
         for(int i=0;i<wordDict.size();i++){
            st.add(wordDict.get(i));
         }
         int n=s.length();
         int[] dp=new int[n];
         Arrays.fill(dp,-1);
         int res=solve(0,s,dp);
         return res==0 ? false : true;
    }
}