class Solution {
    private int solve(int row, int col, int[][] dungeon,int[][] dp) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        if (row >= n || col >= m)
            return Integer.MAX_VALUE;

        if (row == n - 1 && col == m - 1)
            return Math.max(1, 1 - dungeon[row][col]);
        
        if(dp[row][col]!=-1) return dp[row][col];
        int right = solve(row, col + 1, dungeon,dp);
        int down = solve(row + 1, col, dungeon,dp);

        int need = Math.min(right, down);
        return dp[row][col] = Math.max(1, need - dungeon[row][col]);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(0, 0, dungeon,dp);
    }
}