class Solution {
    int[] psum;
    double[][] dp;
    private double solve(int ind,int k,int[] nums,int n){
        if(ind>=n) return 0.0;
        if(dp[ind][k]!=-1.0) return dp[ind][k];
        double ans=0.0;
        if(k<=1){
            int wsum=psum[n]-psum[ind];
            return dp[ind][k]=(double)wsum/(n-ind)*1.00000;
        }
        else{
            for(int j=ind;j<n-1;j++){
                int wsum=psum[j+1]-psum[ind];
                double res=(double)wsum/(j-ind+1)+solve(j+1,k-1,nums,n);
                ans=Math.max(ans,res);
            }
        }
        return dp[ind][k]=ans;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        int n=nums.length;
        psum=new int[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=nums[i]+psum[i];
        }
        dp=new double[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1.0);
        }
        return solve(0,k,nums,n);
    }
}