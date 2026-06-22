class Solution {
    private int solve(int row,int col,char[][] grid,int bal,int[][][] dp){
         if(row<0 || col<0) return 0;
         char ch=grid[row][col];
         if(ch==')') bal++;
         else bal--;
         if(bal<0) return 0;
         if(row==0 && col==0){
            if(bal==0) return 1;
            return 0;
         }
         if(dp[row][col][bal]!=-1) return dp[row][col][bal];

         int w1=solve(row-1,col,grid,bal,dp);
         int w2=solve(row,col-1,grid,bal,dp);

         return dp[row][col][bal]=(w1==1 || w2==1 ? 1 : 0);
    }
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==')' || grid[m-1][n-1]=='(') return false;
        int[][][] dp=new int[m][n][m+n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m+n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        int ans= solve(m-1,n-1,grid,0,dp);
        return ans==1 ? true : false;
    }
}