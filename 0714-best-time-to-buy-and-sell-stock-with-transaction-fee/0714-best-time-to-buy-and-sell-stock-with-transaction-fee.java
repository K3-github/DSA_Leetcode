class Solution {
    public int maxProfit(int[] p,int fee) {
        int n=p.length;
        int[][] dp=new int[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                if(buy==1){
                    int w1=p[ind]-fee+dp[ind+1][0];
                    int w2=dp[ind+1][1];
                    dp[ind][buy]=Math.max(w1,w2);
                }
                else{
                    int w1=-p[ind]+dp[ind+1][1];
                    int w2=dp[ind+1][0];
                    dp[ind][buy]=Math.max(w1,w2);
                }
            }
        }
        return dp[0][0];
    }
}