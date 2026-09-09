class Solution {
    int[] digits;
    int len;

    private long solve(int pos, boolean tight, int dgs, boolean started, long[][][] dp) {
        if (pos == len) {
            if(!started) return 0;
            return (dgs - 1) / 3;
        }

        if (!tight && dp[pos][dgs][started ? 1 : 0] != -1) {
            return dp[pos][dgs][started ? 1 : 0];
        }

        int limit = tight ? digits[pos] : 9;
        long ans = 0;

        for (int digit = 0; digit <= limit; digit++) {

            boolean newTight = tight && (digit == digits[pos]);

            boolean newStarted = started || digit != 0;

            int newDgs = dgs;
            if (newStarted) {
                newDgs++;
            }
            ans += solve(pos + 1, newTight, newDgs, newStarted, dp);
        }

        if (!tight) {
            dp[pos][dgs][started ? 1 : 0] = ans;
        }

        return ans;
    }

    public long countCommas(long n) {

        String str = String.valueOf(n);

        len = str.length();
        digits = new int[len];

        for (int i = 0; i < len; i++) {
            digits[i] = str.charAt(i) - '0';
        }

        long[][][] dp = new long[len][len + 1][2];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= len; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, true, 0, false, dp);
    }
}
