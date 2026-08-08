class Solution {
    private boolean isGood(int num) {
        boolean changed = false;
        while (num > 0) {
            int digit = num % 10;
            if(digit == 0 || digit == 1 || digit == 8){}
            else if(digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                changed = true;
            }
            else return false;
            num /= 10;
        }
        return changed;
    }

    public int rotatedDigits(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}