class Solution {
    private int solve(int ind,int buy,int[] p,int[][] dp){
        int n=p.length;
        if(ind>=n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];

        if(buy==1){
            int w1=p[ind]+solve(ind+1,0,p,dp);
            int w2=solve(ind+1,1,p,dp);
            return dp[ind][buy]=Math.max(w1,w2);
        }
        else{
            int w1=-p[ind]+solve(ind+1,1,p,dp);
            int w2=solve(ind+1,0,p,dp);
            return dp[ind][buy]=Math.max(w1,w2);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,prices,dp);
    }
}