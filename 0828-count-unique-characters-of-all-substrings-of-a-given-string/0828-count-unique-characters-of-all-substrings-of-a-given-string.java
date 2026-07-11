class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        List<Integer>[] pos = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
            pos[i].add(-1);
        }

        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - 'A'].add(i);
        }

        int ans = 0;

        for (int i = 0; i < 26; i++) {
            pos[i].add(n);

            for (int j = 1; j < pos[i].size() - 1; j++) {
                int prev = pos[i].get(j - 1);
                int curr = pos[i].get(j);
                int next = pos[i].get(j + 1);

                ans += (curr - prev) * (next - curr);
            }
        }

        return ans;
    }
}