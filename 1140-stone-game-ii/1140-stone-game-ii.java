class Solution {
    int[] psum;
    private int solve(int index, int m, int[] piles, int[][] dp) {
        if (index >= piles.length) return 0;
        if (dp[index][m] != -1) return dp[index][m];

        int total = psum[piles.length] - psum[index];
        int ans = 0;
        for(int x=1;x<=Math.min(2*m,piles.length-index);x++) {
            int newM = Math.max(m,x);
            ans = Math.max(ans,total-solve(index + x, newM, piles, dp));
        }

        return dp[index][m] = ans;
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        psum=new int[n+1];
        for(int i=0;i<n;i++){
           psum[i+1]=piles[i]+psum[i];
        }
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,1,piles,dp);
    }
}

