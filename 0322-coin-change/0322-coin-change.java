class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],10000000);
        }
        for(int i=0;i<n;i++) dp[i][0]=0;
        for(int amt=1;amt<=amount;amt++){
            if(coins[0]<=amt){
                if(amt%coins[0]==0) dp[0][amt]=amt/coins[0];
            }
        }
        for(int ind=1;ind<n;ind++){
            for(int amt=1;amt<=amount;amt++){
                int w1=10000000;
                if(coins[ind]<=amt){
                    w1=1+dp[ind][amt-coins[ind]];
                }
                int w2=dp[ind-1][amt];
                dp[ind][amt]=Math.min(w1,w2);
            }
        }
        int ans=dp[n-1][amount];
        if(ans==10000000) return -1;
        return ans;
    }
}