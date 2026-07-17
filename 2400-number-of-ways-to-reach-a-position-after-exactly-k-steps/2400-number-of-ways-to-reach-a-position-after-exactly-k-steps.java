class Solution {
    int mod=1000000007;
    private int solve(int pos,int k,int target,int[][] dp){
        if(k==0){
            return pos==target ? 1 : 0;
        }
        if(dp[1000+pos][k]!=-1) return dp[1000+pos][k];

        long ans=0;
        ans+=solve(pos-1,k-1,target,dp);
        ans+=solve(pos+1,k-1,target,dp);
        return dp[1000+pos][k]=(int)(ans%mod);
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp=new int[3001][1001];
        for(int i=0;i<3001;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(startPos,k,endPos,dp);
    }
}