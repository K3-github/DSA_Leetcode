class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        int minLen = n + 1;
        String ans = "";
        while (right < n) {
            if (s.charAt(right) == '1') {
                k--;
            }
            while (left<=right && k == 0) {
                int currLen = right - left + 1;
                String sub = s.substring(left, right + 1);
                if (currLen < minLen || 
                    (currLen == minLen && sub.compareTo(ans) < 0)) {
                    minLen = currLen;
                    ans = sub;
                }
                if (s.charAt(left) == '1') {
                    k++;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}