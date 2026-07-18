class Solution {
    int[] dr=new int[]{0,+1,0,-1};
    int[] dc=new int[]{+1,0,-1,0};
    private void solve(int row,int col,int[][] vis,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m || vis[row][col]==1 || grid[row][col]==1) return;

        vis[row][col]=1;
        
        for(int d=0;d<4;d++){
            int nr=row+dr[d];
            int nc=col+dc[d];
            solve(nr,nc,vis,grid);
        }
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && grid[i][0]==0){
                solve(i,0,vis,grid);
            }
            if(vis[i][m-1]==0 && grid[i][m-1]==0){
                solve(i,m-1,vis,grid);
            }
        }
        for(int j=0;j<m;j++){
            if(vis[0][j]==0 && grid[0][j]==0){
                solve(0,j,vis,grid);
            }
            if(vis[n-1][j]==0 && grid[n-1][j]==0){
                solve(n-1,j,vis,grid);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==0){
                    solve(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
}