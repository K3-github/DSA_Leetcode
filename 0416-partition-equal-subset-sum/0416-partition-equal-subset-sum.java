class Solution {
    private int solve(int ind,int curr,int sum,int[] nums,int[][] dp){
        if(curr==sum) return 1;
        if(ind<0) return 0;
        if(dp[ind][curr]!=-1) return dp[ind][curr];
        
        int w1=0;
        if(curr+nums[ind]<=sum) w1=solve(ind-1,curr+nums[ind],sum,nums,dp);
        int w2=solve(ind-1,curr,sum,nums,dp);

        return dp[ind][curr]= (w1 == 1 || w2 == 1) ? 1 : 0;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int req=sum/2;
        int[][] dp=new int[n][req+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=req;j++){
                dp[i][j]=-1;
            }
        }
        int ans=solve(n-1,0,req,nums,dp);
        return ans == 1 ? true : false;
    }
}