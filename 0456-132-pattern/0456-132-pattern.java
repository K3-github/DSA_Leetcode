class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int left = nums[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 2; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > left) {
                Integer x = map.lowerKey(nums[i]);
                if (x != null && x > left)
                    return true;
            }
            left = Math.min(left, nums[i]);

            int cnt = map.get(nums[i + 1]);
            if (cnt == 1) {
                map.remove(nums[i + 1]);
            } else {
                map.put(nums[i + 1], cnt - 1);
            }
        }
        return false;
    }
}