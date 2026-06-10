class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;count[i]=1;
        }
        int lis=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]<1+dp[j]){
                        count[i]=count[j];
                        dp[i]=1+dp[j];
                    }
                    else if(dp[i]==1+dp[j]){
                         count[i]+=count[j];
                    }
                }
            }
            lis=Math.max(lis,dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
           if(dp[i]==lis) ans+=count[i];
        }
        return ans;
    }
}