class Solution {
    private int solve(int ind,int n,String s,int[] dp){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int maxi=Integer.MAX_VALUE;
        int unique=0,maxF=0;
        int[] cnt=new int[26];
        for(int j=ind;j<n;j++){
            char ch=s.charAt(j);
            if(cnt[ch-'a']==0) unique++;
            cnt[ch-'a']++;
            maxF=Math.max(maxF,cnt[ch-'a']);
            int len=j-ind+1;
            if(len==maxF*unique){
                int part=solve(j+1,n,s,dp);
                if(part!=Integer.MAX_VALUE) maxi=Math.min(maxi,1+part);
            }
        }
        return dp[ind]=maxi;
    }
    public int minimumSubstringsInPartition(String s) {
        int n=s.length();
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=-1;
        return solve(0,n,s,dp);
    }
}