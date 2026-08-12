class Solution {
    int[] dp;
    private int solve(int ind,int[] days,int[] costs){
        int n=days.length;
        if(ind>=days.length) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int i=ind;
        while(i<n && days[i]<days[ind]+1){
            i++;
        }
        int w1=costs[0]+solve(i,days,costs);
        i=ind;
        while(i<n && days[i]<days[ind]+7){
            i++;
        }
        int w2=costs[1]+solve(i,days,costs);
        i=ind;
        while(i<n && days[i]<days[ind]+30){
            i++;
        }
        int w3=costs[2]+solve(i,days,costs);
        return dp[ind]=Math.min(w1,Math.min(w2,w3));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,days,costs);
    }
}