class Solution {
    private boolean solve(int row,int col,int[][] grid1,int[][] grid2){
        int n=grid2.length;
        int m=grid2[0].length;
        if(row<0 || row>=n || col<0 || col>=m || grid2[row][col]==0) return true;

        boolean ans=true;
        grid2[row][col]=0;

        if(grid1[row][col]==0){
            ans=false;
        }
        
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};
        
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            if(solve(nrow,ncol,grid1,grid2)==false) ans=false;
        }
        return ans;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid2.length;
        int m=grid2[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && solve(i,j,grid1,grid2)==true) count++;
            }
        }
        return count;
    }
}