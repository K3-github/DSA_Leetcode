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
    public int maxProfit(int[] p) {
        int n=p.length;
        int[][][] dp=new int[n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<2;buy++){
                for(int rt=1;rt<3;rt++){
                    if(buy==1){
                        int w1=p[ind]+dp[ind+1][0][rt-1];
                        int w2=dp[ind+1][1][rt];
                        dp[ind][buy][rt]=Math.max(w1,w2);
                    }
                    else{
                        int w1=-p[ind]+dp[ind+1][1][rt];
                        int w2=dp[ind+1][0][rt];
                        dp[ind][buy][rt]=Math.max(w1,w2);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}