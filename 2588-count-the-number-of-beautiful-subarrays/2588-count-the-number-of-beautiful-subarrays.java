class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int xor = 0;
        long ans = 0;
        for (int num : nums) {
            xor ^= num;
            ans += mp.getOrDefault(xor, 0);
            mp.put(xor, mp.getOrDefault(xor, 0) + 1);
        }
        return ans;
    }
}