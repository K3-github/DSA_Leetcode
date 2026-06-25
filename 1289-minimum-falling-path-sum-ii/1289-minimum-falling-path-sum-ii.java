class Solution {
    // private int solve(int row,int pCol,int[][] grid,int[][] dp){
    //     int n=grid.length;
    //     int m=grid[0].length;
    //     if(row>=n) return 0;
    //     if(dp[row][pCol]!=-1) return dp[row][pCol];
    //     int ans=1000000;
    //     for(int col=0;col<m;col++){
    //         if(col!=pCol){
    //           ans=Math.min(ans,grid[row][col]+solve(row+1,col,grid,dp));
    //         }
    //     }
    //     return dp[row][pCol]=ans;
    // }
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n+1][m+1];
        for(int j=0;j<=m;j++) dp[n][j]=0;

        for(int row=n-1;row>=0;row--){
            for(int pCol=0;pCol<=m;pCol++){
                int ans=1000000;
                for(int col=0;col<m;col++){
                    if(col!=pCol){
                       ans=Math.min(ans,grid[row][col]+dp[row+1][col]);
                    }
                }
                dp[row][pCol]=ans;
            }
        }
        return dp[0][m];
    }
}