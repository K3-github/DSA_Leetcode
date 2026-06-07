class Solution {
    private int solve(int ind,int buy,int rt,int[] p,int[][][] dp){
        int n=p.length;
        if(ind>=n) return 0;
        if(rt<=0) return 0;
        if(dp[ind][buy][rt]!=-1) return dp[ind][buy][rt];

        if(buy==1){
            int w1=p[ind]+solve(ind+1,0,rt-1,p,dp);
            int w2=solve(ind+1,1,rt,p,dp);
            return dp[ind][buy][rt]=Math.max(w1,w2);
        }
        else{
            int w1=-p[ind]+solve(ind+1,1,rt,p,dp);
            int w2=solve(ind+1,0,rt,p,dp);
            return dp[ind][buy][rt]=Math.max(w1,w2);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(0,0,2,prices,dp);
    }
}