class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        int left = -1;
        for (int right = 0; right <= n; right++) {
            if (right != n && arr[right] == '.') continue;
            char leftChar = (left == -1) ? 'L' : arr[left];
            char rightChar = (right == n) ? 'R' : arr[right];
            if (leftChar == rightChar) {
                for (int k = left + 1; k < right; k++)
                    arr[k] = leftChar;

            } else if (leftChar == 'R' && rightChar == 'L') {
                int i = left + 1;
                int j = right - 1;
                while (i < j) {
                    arr[i++] = 'R';
                    arr[j--] = 'L';
                }
            }
            left = right;
        }
        return new String(arr);
    }
}