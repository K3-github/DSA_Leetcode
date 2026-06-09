class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        int ans=1;
        for(int ind=0;ind<n;ind++){
            for(int prev=ind-1;prev>=0;prev--){
                 if(nums[ind]>nums[prev]){
                    dp[ind]=Math.max(dp[ind],1+dp[prev]);
                 }
            }
            ans=Math.max(ans,dp[ind]);
        }
        return ans;
    }
}