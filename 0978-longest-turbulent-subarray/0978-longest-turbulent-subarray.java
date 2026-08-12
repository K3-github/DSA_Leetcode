class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int up = 0;
        int down = 0;
        int ans = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
                down = 0;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
                up = 0;
            } else {
                up = 0;
                down = 0;
            }
            ans = Math.max(ans, Math.max(up, down) + 1);
        }
        return ans;
    }
}