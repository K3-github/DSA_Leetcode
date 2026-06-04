class Solution {
    private int solve(int ind,int[] nums,int[] dp){
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int left=nums[ind]+solve(ind-2,nums,dp);
        int right=solve(ind-1,nums,dp);

        return dp[ind]=Math.max(left,right);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=-1;
        return solve(n-1,nums,dp);
    }
}