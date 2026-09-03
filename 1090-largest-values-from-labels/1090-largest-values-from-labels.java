class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n=values.length;
        int[][] vec=new int[n][2];
        for(int i=0;i<n;i++){
            vec[i]=new int[]{values[i],labels[i]};
        }
        Arrays.sort(vec, (a, b) -> Integer.compare(b[0], a[0]));
        HashMap<Integer,Integer> mp=new HashMap<>();
        int ans=0;
        for(int i = 0; i < n && numWanted > 0; i++) {
            int label = vec[i][1];
            int count = mp.getOrDefault(label, 0);
            if(count < useLimit) {
                ans += vec[i][0];
                numWanted--;
                mp.put(label, count + 1);
            }
        }
        return ans;
    }
}