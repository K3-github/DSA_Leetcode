class Solution {
    private int solve(int ind,int amt,int[] coins,int[][] dp){
        if(amt==0) return 0;
        if(ind<0){
            return 10000000;
        }
        if(dp[ind][amt]!=-1) return dp[ind][amt];

        int w1=10000000;
        if(coins[ind]<=amt){
            w1=1+solve(ind,amt-coins[ind],coins,dp);
        }
        int w2=solve(ind-1,amt,coins,dp);
        return dp[ind][amt]=Math.min(w1,w2);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        int ans=solve(n-1,amount,coins,dp);
        return ans == 10000000 ? -1 : ans;
    }
}