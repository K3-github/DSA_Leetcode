class Solution {
    private int gcd(int a, int b) {
       if(b==0) return a;
       return gcd(b,a%b);
    }
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        int g = gcd(n, k);

        long ans = 0;
        for (int i = 0; i < g; i++) {
            List<Integer> values = new ArrayList<>();
            for (int j = i; j < n; j += g) {
                values.add(arr[j]);
            }
            Collections.sort(values);
            int median = values.get(values.size() / 2);
            for (int x : values) {
                ans += Math.abs(x - median);
            }
        }
        return ans;
    }
}