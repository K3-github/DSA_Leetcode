class Solution {
    int[] drow=new int[]{0,+1,0,-1};
    int[] dcol=new int[]{+1,0,-1,0};
    int n,m;
    private boolean solve(int row,int col,int prow,int pcol,char[][] grid,boolean[][] vis){
        vis[row][col]=true;
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==grid[row][col]){
                if(!vis[nrow][ncol]){
                    if(solve(nrow,ncol,row,col,grid,vis)) return true;
                }
                else if(nrow!=prow && ncol!=pcol) return true;
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if(solve(i,j,-1,-1,grid,vis)) return true;
                }
            }
        }
        return false;
    }
}