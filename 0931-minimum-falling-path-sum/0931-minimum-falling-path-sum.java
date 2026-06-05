class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n=mat.length;
        int[][] dp=new int[n][n];
        for(int j=0;j<n;j++){
            dp[0][j]=mat[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int left=10000000,right=10000000;
                if(j>0) left=dp[i-1][j-1];
                if(j<n-1) right=dp[i-1][j+1];
                int up=dp[i-1][j];
                dp[i][j]=mat[i][j]+Math.min(left,Math.min(up,right));
            }
        }
        int ans=10000000;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[n-1][j]);
        }
        return ans;
    }
}