class Solution {
    private int solve(int row1,int row2,int col1,int[][] grid,int[][][] dp){
        int col2=row1+col1-row2;
        if(row1<0 || col1<0 || col2<0 || row2<0) return -100000000;
        if(grid[row1][col1]==-1 || grid[row2][col2]==-1) return -100000000;
        if(row1==0 && row2==0 && col1==0 && col2==0) return grid[row1][col1];
        if(dp[row1][row2][col1]!=-1) return dp[row1][row2][col1];

        int cherry=0;
        if(col1==col2) cherry=grid[row1][col1];
        else cherry=grid[row1][col1]+grid[row2][col2];

        int w1=cherry+solve(row1,row2,col1-1,grid,dp);
        int w2=cherry+solve(row1-1,row2-1,col1,grid,dp);
        int w3=cherry+solve(row1,row2-1,col1-1,grid,dp);
        int w4=cherry+solve(row1-1,row2,col1,grid,dp);

        return dp[row1][row2][col1]=Math.max(w1,Math.max(w2,Math.max(w3,w4)));
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int[][][] dp=new int[n][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int ans=solve(n-1,n-1,n-1,grid,dp);
        return ans<0 ? 0: ans;
    }
}