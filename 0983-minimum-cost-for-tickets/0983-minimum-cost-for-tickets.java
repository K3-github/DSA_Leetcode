class Solution {
    int[][] dp;
    private int solve(int ind,int pass,int[] days,int[] costs){
        if(ind>=days.length) return 0;
        if(dp[ind][pass]!=-1) return dp[ind][pass];
        int ans=4000000;
        if(pass<days[ind]){
          int w1=costs[0]+solve(ind+1,days[ind],days,costs);
          int w2=costs[1]+solve(ind+1,days[ind]+6,days,costs);
          int w3=costs[2]+solve(ind+1,days[ind]+29,days,costs);
          ans=Math.min(w1,Math.min(w2,w3));
        }
        if(pass >= days[ind]){
            return dp[ind][pass]=solve(ind + 1, pass, days, costs);
        }
        return dp[ind][pass]=ans;
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        dp=new int[n][365+30+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,days,costs);
    }
}