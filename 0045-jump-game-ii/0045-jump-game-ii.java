class Solution {
    private int solve(int ind,int n,int[] nums,int[] dp){
        if(ind==n-1) return 0;
        if(ind>=n) return Integer.MAX_VALUE;
        if(dp[ind]!=-1) return dp[ind];
        int ans=Integer.MAX_VALUE;
        for(int j=1;j<Math.min(nums[ind]+1,n);j++){
            int jumps=solve(ind+j,n,nums,dp);
            if(jumps!=Integer.MAX_VALUE){
                ans=Math.min(ans,1+jumps);
            }
        }
        return dp[ind]=ans;
    }
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=solve(0,n,nums,dp);
        return ans== Integer.MAX_VALUE ? -1 : ans;
    }
}