class Solution {

    private int[] solve(int[] nums, int start, int end, int turn) {

        if (start > end)
            return new int[]{0, 0};

        if (turn == 0) { // Player 1's turn

            int[] left = solve(nums, start + 1, end, 1);
            int[] right = solve(nums, start, end - 1, 1);

            left = new int[]{left[0] + nums[start], left[1]};
            right = new int[]{right[0] + nums[end], right[1]};

            if (left[0] > right[0])
                return left;
            else
                return right;

        } else { // Player 2's turn

            int[] left = solve(nums, start + 1, end, 0);
            int[] right = solve(nums, start, end - 1, 0);

            left = new int[]{left[0], left[1] + nums[start]};
            right = new int[]{right[0], right[1] + nums[end]};

            if (left[1] > right[1])
                return left;
            else
                return right;
        }
    }

    public boolean predictTheWinner(int[] nums) {
        int[] ans = solve(nums, 0, nums.length - 1, 0);
        return ans[0] >= ans[1];
    }
}