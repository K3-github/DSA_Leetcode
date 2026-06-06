class Solution {
    private int solve(int row,int col1,int col2,int[][] grid,int[][][] dp){
        int n=grid.length;
        int m=grid[0].length;
        if(col1<0 || col1>=m || col2<0 || col2>=m) return -100000000;
        if(row>=n) return 0;
        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];

        int cherry=0;
        if(col1==col2) cherry+=grid[row][col1];
        else cherry+=grid[row][col1]+grid[row][col2];
        
        int maxi=-100000000;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int points=cherry+solve(row+1,col1-i,col2-j,grid,dp);
                maxi=Math.max(maxi,points);
            }
        }
        return dp[row][col1][col2]=maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int j=0;j<m;j++){
            for(int k=j;k<m;k++){
                if(j==k){
                   dp[n-1][j][k]=grid[n-1][j];
                }
                else{
                    dp[n-1][j][k]=grid[n-1][j]+grid[n-1][k];
                }
            }
        }
        for(int row=n-2;row>=0;row--){
            for(int col1=0;col1<m;col1++){
                for(int col2=0;col2<m;col2++){
                    int maxi=-100000000;
                    for(int i=-1;i<=1;i++){
                        for(int j=-1;j<=1;j++){
                            int value=0;
                            if(col1==col2){
                                value=grid[row][col1];
                            }
                            else value=grid[row][col1]+grid[row][col2];
                            if(col1-i>=0 && col1-i<m && col2-j>=0 && col2-j<m){
                                value+=dp[row+1][col1-i][col2-j];
                            }
                            else value+=-100000000;
                            maxi=Math.max(maxi,value);
                        }
                    }
                  dp[row][col1][col2]=maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
}