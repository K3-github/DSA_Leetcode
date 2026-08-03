class Solution {
    int INF=Integer.MIN_VALUE;
    private int solve(int index,int[] stoneValue,int[] dp){
        int n=stoneValue.length;
        if(index>=n) return 0;
        if(dp[index]!=INF) return dp[index];

        int ans=-100000000;
        int score=0;
        for(int i=index;i<Math.min(n,index+3);i++){
           score=score+stoneValue[i];
           ans=Math.max(ans,score-solve(i+1,stoneValue,dp));
        }
        return dp[index]=ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        int[] dp=new int[stoneValue.length];
        Arrays.fill(dp,INF);
        int result=solve(0,stoneValue,dp);
        if(result==0) return "Tie";
        if(result>0) return "Alice";
        return "Bob";
    }
}