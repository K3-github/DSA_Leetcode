class Solution {
    private int solve(int i,int j,int[][] obs,int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(obs[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int left=solve(i,j-1,obs,dp);
        int up=solve(i-1,j,obs,dp);
        return dp[i][j]=left+up;
    }
    public int uniquePathsWithObstacles(int[][] obs) {
        int m=obs.length;
        int n=obs[0].length;

        if(obs[0][0]==1 || obs[m-1][n-1]==1) return 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(m-1,n-1,obs,dp);
    }
}