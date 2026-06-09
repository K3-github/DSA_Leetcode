class Solution {
    private int solve(int ind,int prev,int n,int[] nums,int[][] dp){
        if(ind>=n) return 0;
        if(dp[ind][prev]!=-1) return dp[ind][prev];

        int w1=0;
        if(prev==n || nums[ind]>nums[prev]){
            w1=1+solve(ind+1,ind,n,nums,dp);
        }
        int w2=solve(ind+1,prev,n,nums,dp);
        return dp[ind][prev]=Math.max(w1,w2);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,n,n,nums,dp);
    }
}