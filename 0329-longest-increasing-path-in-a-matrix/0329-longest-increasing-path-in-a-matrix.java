class Solution {
    private int solve(int row,int col,int[][] mt,int[][] vis,int[][] dp){
        int n=mt.length;
        int m=mt[0].length;
        if(row<0 || col<0 || row>=n || col>=m || vis[row][col]==1) return 0;
        if(dp[row][col]!=-1) return dp[row][col];

        vis[row][col]=1;
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};
        
        int ans=0;
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mt[nrow][ncol]>mt[row][col]){
               ans=Math.max(ans,1+solve(nrow,ncol,mt,vis,dp));
            }
        }
        vis[row][col]=0;
        return dp[row][col]=ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int ans=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] vis=new int[n][m];
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,1+solve(i,j,matrix,vis,dp));
            }
        }
        return ans;
    }
}