class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;cnt[i]=1;
        }
        int lis=0;
        for(int curr=0;curr<n;curr++){
            for(int prev=curr-1;prev>=0;prev--){
                if(nums[curr]>nums[prev]){
                    if(dp[curr]<1+dp[prev]){
                        dp[curr]=1+dp[prev];
                        cnt[curr]=cnt[prev];
                    }
                    else if(dp[curr]==1+dp[prev]){
                        cnt[curr]+=cnt[prev];
                    }
                }
            }
            lis=Math.max(lis,dp[curr]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==lis) ans+=cnt[i];
        }
        return ans;
    }
}