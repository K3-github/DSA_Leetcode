class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2!=0) return false;
        int req=sum/2;
        boolean[][] dp=new boolean[n][req+1];
        for(int i=0;i<n;i++) dp[i][0]=false;
        if(nums[0]<=req){
            dp[0][nums[0]]=true;
        }
        for(int i=1;i<n;i++){
            for(int curr=1;curr<=req;curr++){
                boolean w1=false;
                if(nums[i]<=curr) w1=dp[i-1][curr-nums[i]];
                boolean w2=dp[i-1][curr];
                dp[i][curr] = w1 || w2;
            }
        }
        return dp[n-1][req];
    }
}