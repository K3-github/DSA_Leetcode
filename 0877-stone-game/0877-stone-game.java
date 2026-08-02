class Solution {
    private int solve(int[] piles, int left, int right,int[][] dp) {
        if(left==right) return piles[left];
        if(dp[left][right]!=-1) return dp[left][right];

        int pickLeft = piles[left] - solve(piles, left + 1, right,dp);
        int pickRight = piles[right] - solve(piles, left, right - 1,dp);

        return dp[left][right]=Math.max(pickLeft, pickRight);
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(piles, 0, piles.length - 1,dp) >= 0;
    }
}
