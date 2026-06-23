class Solution {
    private int solve(int row,int col,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0) return 0;
        
        int point=grid[row][col];
        grid[row][col]=0;

        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};
        int ans=0;
        for(int i=0;i<4;i++){
          int nrow=row+drow[i];
          int ncol=col+dcol[i];
          int points=point+solve(nrow,ncol,grid);
          ans=Math.max(ans,points);
        }
        grid[row][col]=point;
        return ans;
    }
    public int getMaximumGold(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,solve(i,j,grid));
            }
        }
        return ans;
    }
}