class Solution {
    private long solve(int row,int col,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0) return 0;

        long cc=grid[row][col];
        grid[row][col]=0;

        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};
        
        long ans=0;
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            ans+=solve(nrow,ncol,grid);
        }
        return cc+ans;
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0){
                    long val=solve(i,j,grid);
                    if(val%k==0) count++;
                }
            }
        }
        return count;
    }
}