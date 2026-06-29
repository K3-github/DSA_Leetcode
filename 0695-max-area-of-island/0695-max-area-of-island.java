class Solution {
    private int solve(int row,int col,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0) return 0;

        grid[row][col]=0;
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};

        int ans=0;
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            ans+=solve(nrow,ncol,grid);
        }
        return 1+ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,solve(i,j,grid));
                }
            }
        }
        return ans;
    }
}