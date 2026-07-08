class Solution {
    static int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length(), q = queries.length;
        int[] prefixSum = new int[n + 1];
        int[] digitsCount = new int[n + 1];
        int[] prefixVal = new int[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            prefixSum[i + 1] = prefixSum[i];
            digitsCount[i + 1] = digitsCount[i];
            prefixVal[i + 1] = prefixVal[i];
            if (num != 0) {
                prefixSum[i + 1] += num;
                digitsCount[i + 1]++;
                prefixVal[i + 1] = (int) (((long) prefixVal[i] * 10 + num) % MOD);
            }
        }
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int sum = prefixSum[r + 1] - prefixSum[l];
            int cnt = digitsCount[r + 1] - digitsCount[l];
            long x = (prefixVal[r + 1]
                    - ((long) prefixVal[l] * pow10[cnt]) % MOD
                    + MOD) % MOD;

            res[i] = (int) (x * sum % MOD);
        }
        return res;
    }
}