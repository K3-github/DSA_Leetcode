class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        List<Map<Long, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int prev = dp.get(j).getOrDefault(diff, 0);
                ans += prev;
                dp.get(i).put(diff, dp.get(i).getOrDefault(diff, 0) + prev + 1
                );
            }
        }
        return (int) ans;
    }
}