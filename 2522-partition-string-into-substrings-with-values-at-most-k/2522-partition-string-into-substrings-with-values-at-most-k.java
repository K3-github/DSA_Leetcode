class Solution {
    private int solve(int ind,int n,String s,int k,int[] dp){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        long curr=0;
        int ans=100000000;
        for(int j=ind;j<n;j++){
            curr = curr*10 + (s.charAt(j)-'0');
            if(curr>k) break;
            ans=Math.min(ans,1+solve(j+1,n,s,k,dp));
        }
        return dp[ind]=ans;
    }
    public int minimumPartition(String s, int k) {
        int n=s.length();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int ans=solve(0,n,s,k,dp);
        return ans==100000000 ? -1 : ans;
    }
}