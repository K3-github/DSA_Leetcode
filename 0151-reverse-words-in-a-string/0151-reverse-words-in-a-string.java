class Solution {

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && arr[j] == ' ') j++;

            while (j < n && arr[j] != ' ') arr[i++] = arr[j++];

            while (j < n && arr[j] == ' ') j++;

            if (j < n) arr[i++] = ' ';
        }

        int len = i;
        reverse(arr, 0, len - 1);

        int start = 0;
        for (int end = 0; end <= len; end++) {
            if (end == len || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }
        return new String(arr, 0, len);
    }
}