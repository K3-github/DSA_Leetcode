class Solution {
    int mod=1000000007;
    private int solve(int row,int col,int curr,int k,int[][] grid,int[][][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0|| col<0) return 0;
        curr=(curr+grid[row][col])%k;
        if(row==0 && col==0){
            if(curr%k==0) return 1;
            return 0;
        }
        if(dp[row][col][curr]!=-1) return dp[row][col][curr];
        int w1=solve(row-1,col,curr,k,grid,dp)%mod;
        int w2=solve(row,col-1,curr,k,grid,dp)%mod;
        return dp[row][col][curr]=(w1+w2)%mod;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int curr=0;
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int p=0;p<k;p++){
                    dp[i][j][p]=-1;
                }
            }
        }
        return solve(n-1,m-1,0,k,grid,dp)%mod;
    }
}