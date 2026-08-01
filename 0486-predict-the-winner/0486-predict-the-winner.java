class Solution {
    private int solve(int[] nums, int left, int right) {
        if (left > right) return 0;

        int pickLeft = nums[left] - solve(nums, left + 1, right);
        int pickRight = nums[right] - solve(nums, left, right - 1);

        return Math.max(pickLeft, pickRight);
    }

    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1) >= 0;
    }
}