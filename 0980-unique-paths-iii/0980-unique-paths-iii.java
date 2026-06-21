class Solution {
    int emCells=0;
    private int solve(int i,int j,int cnt,int[][] grid,int[][] vis){
          int n=grid.length;
          int m=grid[0].length;
          if(i<0 || i>=n || j<0 || j>=m) return 0;
          if(grid[i][j]==-1 || vis[i][j]==1) return 0;
          if(grid[i][j]==2){
            if(cnt==emCells) return 1;
            return 0;
          }
          if(grid[i][j]==0) cnt++;
          vis[i][j]=1;
          int[] dx=new int[]{-1,0,+1,0};
          int[] dy=new int[]{0,+1,0,-1};
          
          int ans=0;
          for(int d=0;d<4;d++){
              int di=i+dx[d];
              int dj=j+dy[d];
              ans+=solve(di,dj,cnt,grid,vis);
          }
          vis[i][j]=0;
          if(grid[i][j]==0) cnt--;
          return ans;
    }
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0) emCells++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return solve(i,j,0,grid,vis);
            }
        }
        return -1;
    }
}