class Solution {
    private int solve(int ind,int n,int[] dp){
        if(ind==n) return 1;
        if(ind>n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int w1=solve(ind+1,n,dp);
        int w2=solve(ind+2,n,dp);

        return dp[ind]=w1+w2;
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++) dp[i]=-1;
        return solve(0,n,dp);
    }
}