class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];

        for (int i = 0; i <= n - k; i++) {
            boolean[] seen = new boolean[51];
            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    freq[nums[j]]++;
                    seen[nums[j]] = true;
                }
            }
        }
        int ans = -1;
        for (int i = 0; i <= 50; i++) {
            if (freq[i] == 1) {
                ans = i;
            }
        }
        return ans;
    }
}