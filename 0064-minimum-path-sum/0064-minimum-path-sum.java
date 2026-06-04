class Solution {
    private int solve(int i,int j,int[][] grid,int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return 10000000;
        if(dp[i][j]!=-1) return dp[i][j];

        int left=grid[i][j]+solve(i,j-1,grid,dp);
        int up=grid[i][j]+solve(i-1,j,grid,dp);

        return dp[i][j]=Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                  dp[i][j]=-1;
            }
        }
        return solve(m-1,n-1,grid,dp);
    }
}