class Solution {
    long MOD = 1000000007;
    long[][] nCr = new long[1001][1001];

    public int numOfWays(int[] nums) {
        buildCombination(nums.length);
        List<Integer> arr = new ArrayList<>();
        for (int x : nums) arr.add(x);
        return (int)((solve(arr) - 1 + MOD) % MOD);
    }

    private long solve(List<Integer> nums) {
        int n = nums.size();
        if (n <= 2) return 1;
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < root) left.add(nums.get(i));
            else right.add(nums.get(i));
        }
        long leftWays = solve(left);
        long rightWays = solve(right);
        long waysToMerge = nCr[n - 1][left.size()];
        return (((waysToMerge * leftWays) % MOD) * rightWays) % MOD;
    }
    private void buildCombination(int n) {
        for (int i = 0; i <= n; i++) {
            nCr[i][0] = 1;
            nCr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MOD;
            }
        }
    }
}