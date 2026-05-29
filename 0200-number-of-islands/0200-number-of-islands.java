class Solution {
    private void dfs(int row,int col,char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(row<0 || row>=n || col<0 || col>=m || grid[row][col]=='0') return;
        
        grid[row][col]='0';
        int[] drow=new int[]{-1,0,+1,0};
        int[] dcol=new int[]{0,+1,0,-1};

        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            dfs(nrow,ncol,grid);
        }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}