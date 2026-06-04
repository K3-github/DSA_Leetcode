class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int m=obs.length;
        int n=obs[0].length;

        if(obs[0][0]==1 || obs[m-1][n-1]==1) return 0;

        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=1;
                else if(obs[i][j]==1){
                    dp[i][j]=0;
                }
                else{
                    int left=0,up=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=left+up;
                }
            }
        }
        return dp[m-1][n-1];
    }
}