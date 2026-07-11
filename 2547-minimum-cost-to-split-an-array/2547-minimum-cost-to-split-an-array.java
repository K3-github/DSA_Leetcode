class Solution {
    private int solve(int ind,int[] nums,int k,int[] dp){
        int n=nums.length;
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int ans=Integer.MAX_VALUE;
        int[] freq=new int[n];
        int len=0;
        for(int j=ind;j<n;j++){
            int f=++freq[nums[j]];
            if(f==2) len+=2;
            else if(f>2) len++;
            int res=solve(j+1,nums,k,dp);
            if(res!=Integer.MAX_VALUE){
                ans=Math.min(ans,k+len+res);
            }
        }
        return dp[ind]=ans;
    }
    public int minCost(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,nums,k,dp);
    }
}