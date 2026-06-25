class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] next=new int[m+1];
        for(int j=0;j<=m;j++) next[j]=0;

        for(int row=n-1;row>=0;row--){
            int[] curr=new int[m+1];
            for(int pCol=0;pCol<=m;pCol++){
                int ans=1000000;
                for(int col=0;col<m;col++){
                    if(col!=pCol){
                       ans=Math.min(ans,grid[row][col]+next[col]);
                    }
                }
                curr[pCol]=ans;
            }
            next=curr;
        }
        return next[m];
    }
}