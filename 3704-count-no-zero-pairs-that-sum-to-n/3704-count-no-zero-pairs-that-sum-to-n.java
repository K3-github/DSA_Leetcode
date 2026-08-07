class Solution {
    long[][][][][] dp;
    char[] digits;
    int m;
    private long solve(int pos, int tight, int carry, int lenA, int lenB) {
        if(pos == m) {
            return carry == 0 ? 1 : 0;
        }
        if(dp[pos][tight][carry][lenA][lenB] != -1) {
            return dp[pos][tight][carry][lenA][lenB];
        }
        long ans = 0;
        int limit = tight == 1 ? digits[pos] - '0' : 9;

        int startA = (pos < lenA) ? 1 : 0;
        int endA   = (pos < lenA) ? 9 : 0;

        int startB = (pos < lenB) ? 1 : 0;
        int endB   = (pos < lenB) ? 9 : 0;
        for(int a = startA; a <= endA; a++) {
            for(int b = startB; b <= endB; b++) {
                int sum = a + b + carry;
                int digit = sum % 10;
                int newCarry = sum / 10;
                if (digit != limit) continue;
                int newTight = (tight == 1 && digit == limit) ? 1 : 0;
                ans += solve(pos + 1, newTight, newCarry, lenA, lenB);
            }
        }
        return dp[pos][tight][carry][lenA][lenB] = ans;
    }

    public long countNoZeroPairs(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        digits = sb.toString().toCharArray();
        m = digits.length;
        dp = new long[m + 1][2][2][m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l <= m; l++) {
                        Arrays.fill(dp[i][j][k][l], -1);
                    }
                }
            }
        }
        long ans = 0;
        for (int lenA = 1; lenA <= m; lenA++) {
            for (int lenB = 1; lenB <= m; lenB++) {
                ans += solve(0, 1, 0, lenA, lenB);
            }
        }
        return ans;
    }
}