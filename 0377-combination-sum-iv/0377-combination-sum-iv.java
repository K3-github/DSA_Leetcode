class Solution {
    private int solve(int target,int[] nums,int[] dp){
        if(target==0) return 1;
        if(dp[target]!=-1) return dp[target];

        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i]){
                ans+=solve(target-nums[i],nums,dp);
            }
        }
        return dp[target]=ans;
    }

    public int combinationSum4(int[] nums,int target){
        int[] dp=new int[target+1];
        Arrays.fill(dp,-1);
        return solve(target,nums,dp);
    }
}