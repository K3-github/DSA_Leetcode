class Solution {
    int ans=0;
    private int solve(int root,int[] cost,int n,int[] dp){
        if(root>=n) return 0;
        if(dp[root]!=-1) return dp[root];

        int left=solve(2*root+1,cost,n,dp);
        int right=solve(2*root+2,cost,n,dp);
        
        int mx=Math.max(left,right);
        ans+=2*mx-left-right;
        return dp[root]=cost[root]+mx;
    }
    public int minIncrements(int n, int[] cost) {
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        solve(0,cost,n,dp);
        return ans;
    }
}