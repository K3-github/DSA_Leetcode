class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long curr = 0;
        int count = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            curr+=nums[i];
            if(curr>0) count++;
            else break;
        }
        return count;
    }
}