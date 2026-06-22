class Solution {
    private boolean solve(int row,int col,int[][] grid,int[][] vis){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m || vis[row][col]==1) return false;
        if(row==n-1 && col==m-1) return true;

        vis[row][col]=1;
        int val=grid[row][col];
        if(val==1){
           boolean w1=false;
           if(col-1>=0 && (grid[row][col-1]==1 || grid[row][col-1]==4 || grid[row][col-1]==6)){
            w1=solve(row,col-1,grid,vis);
           }
           boolean w2=false;
           if(col+1<m && (grid[row][col+1]==1 || grid[row][col+1]==3 || grid[row][col+1]==5)){
            w2=solve(row,col+1,grid,vis);
           }
           vis[row][col]=0;
           return w1 || w2;
        }
        else if(val==2){
           boolean w1=false;
           if(row-1>=0 && (grid[row-1][col]==2 || grid[row-1][col]==3 || grid[row-1][col]==4)){
            w1=solve(row-1,col,grid,vis);
           }
           boolean w2=false;
           if(row+1<n && (grid[row+1][col]==2 || grid[row+1][col]==5 || grid[row+1][col]==6)){
            w2=solve(row+1,col,grid,vis);
           }
           vis[row][col]=0;
           return w1 || w2;
        }
        else if(val==3){
           boolean w1=false;
           if(col-1>=0 && (grid[row][col-1]==1 || grid[row][col-1]==4 || grid[row][col-1]==6)){
            w1=solve(row,col-1,grid,vis);
           }
           boolean w2=false;
           if(row+1<n && (grid[row+1][col]==2 || grid[row+1][col]==5 || grid[row+1][col]==6)){
            w2=solve(row+1,col,grid,vis);
           }
           vis[row][col]=0;
           return w1 || w2;
        }
        else if(val==4){
           boolean w1=false;
           if(col+1<m && (grid[row][col+1]==1 || grid[row][col+1]==3 || grid[row][col+1]==5)){
            w1=solve(row,col+1,grid,vis);
           }
           boolean w2=false;
           if(row+1<n && (grid[row+1][col]==2 || grid[row+1][col]==5 || grid[row+1][col]==6)){
            w2=solve(row+1,col,grid,vis);
           }
           vis[row][col]=0;
           return w1 || w2;
        }
        else if(val==5){
           boolean w1=false; 
           if(col-1>=0 && (grid[row][col-1]==1 || grid[row][col-1]==4 || grid[row][col-1]==6)){
            w1=solve(row,col-1,grid,vis);
           }
           boolean w2=false;
           if(row-1>=0 && (grid[row-1][col]==2 || grid[row-1][col]==3 || grid[row-1][col]==4)){
            w2=solve(row-1,col,grid,vis);
           }
           vis[row][col]=0;
           return w1 || w2;
        }
        else{
           boolean w1=false;
           if(col+1<m && (grid[row][col+1]==1 || grid[row][col+1]==3 || grid[row][col+1]==5)){
            w1=solve(row,col+1,grid,vis);
           }
           boolean w2=false;
           if(row-1>=0 && (grid[row-1][col]==2 || grid[row-1][col]==3 || grid[row-1][col]==4)){
            w2=solve(row-1,col,grid,vis);
           }
           vis[row][col]=0;
           return w1 || w2;
        }
    }
    public boolean hasValidPath(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        return solve(0,0,grid,vis);
    }
}