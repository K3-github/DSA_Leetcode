class Solution {
    int[] digits;
    int[][][][] dp;

    private int solve(int pos, int tight, int mask, int started) {
        if (pos == digits.length) {
            return started == 1 ? 1 : 0;
        }
        if (tight == 0 && dp[pos][tight][mask][started] != -1) {
            return dp[pos][tight][mask][started];
        }
        int limit = (tight == 1) ? digits[pos] : 9;
        int ans = 0;
        for (int digit = 0; digit <= limit; digit++) {
            int newTight = (tight == 1 && digit == limit) ? 1 : 0;
            if (started == 0 && digit == 0) {
                ans += solve(pos + 1, newTight, mask, 0);
            } else {
                if ((mask & (1 << digit)) != 0) continue;
                int newMask = mask | (1 << digit);
                ans += solve(pos + 1, newTight, newMask, 1);
            }
        }
        // if (tight == 0){
            
        // }
        return dp[pos][tight][mask][started] = ans;
    }

    public int countSpecialNumbers(int n) {

        String s = String.valueOf(n);
        digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        dp = new int[digits.length][2][1 << 10][2];

        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return solve(0, 1, 0, 0);
    }
}