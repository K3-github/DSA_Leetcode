class Solution {
    private int solve(int ind,int n,int[] nums,int[] dp){
        if(ind==n-1) return 1;
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        for(int j=1;j<Math.min(nums[ind]+1,n);j++){
            int output=solve(ind+j,n,nums,dp);
            if(output==1) return dp[ind]=1;
        }
        return dp[ind]=0;
    }
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=solve(0,n,nums,dp);
        return ans==0 ? false : true;
    }
}