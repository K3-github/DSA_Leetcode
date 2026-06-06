class Solution {
    private int solve(int ind,int amt,int[] c,int[][] dp){
        if(amt==0) return 1;
        if(ind<0) return 0;
        if(dp[ind][amt]!=-1) return dp[ind][amt];

        int w1=0;
        if(c[ind]<=amt){
            w1=solve(ind,amt-c[ind],c,dp);
        }
        int w2=solve(ind-1,amt,c,dp);
        return dp[ind][amt]=w1+w2;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }
        return solve(n-1,amount,coins,dp);
    }
}