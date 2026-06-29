class Solution {
    private int solve(int row,int col,int[][] grid,int k){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]==0) return 0;

        int cc=grid[row][col]%k;
        grid[row][col]=0;

        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};
        
        int ans=0;
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            ans+=solve(nrow,ncol,grid,k)%k;
        }
        return (cc+ans)%k;
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0){
                    int val=solve(i,j,grid,k);
                    if(val%k==0) count++;
                }
            }
        }
        return count;
    }
}