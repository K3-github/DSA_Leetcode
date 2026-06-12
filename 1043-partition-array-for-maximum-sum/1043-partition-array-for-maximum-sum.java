class Solution {
    private int solve(int ind,int n,int k,int[] arr,int[] dp){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int ans=0,len=0,maxi=0;
        for(int j=ind;j<Math.min(ind+k,n);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=maxi*len+solve(j+1,n,k,arr,dp);
            ans=Math.max(ans,sum);
        }
        return dp[ind]=ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=-1;
        return solve(0,n,k,arr,dp);
    }
}