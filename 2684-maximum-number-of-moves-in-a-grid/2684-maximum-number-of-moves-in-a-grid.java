class Solution {
    private int solve(int row,int col,int[][] grid,int[][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m) return 0;
        if(dp[row][col]!=-1) return dp[row][col];
        
        int ans=0;
        if(row-1>=0 && col+1<m && grid[row][col]<grid[row-1][col+1]){
          ans=Math.max(ans,1+solve(row-1,col+1,grid,dp));
        }
        if(col+1<m && grid[row][col]<grid[row][col+1]){
          ans=Math.max(ans,1+solve(row,col+1,grid,dp));
        }
        if(row+1<n && col+1<m && grid[row][col]<grid[row+1][col+1]){
          ans=Math.max(ans,1+solve(row+1,col+1,grid,dp));
        }
        return dp[row][col]=ans;
    }
    public int maxMoves(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<n;i++){
            ans=Math.max(ans,solve(i,0,grid,dp));
        }
        return ans;
    }
}