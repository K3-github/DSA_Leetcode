class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n=values.length;
        int[][] vec=new int[n][2];
        for(int i=0;i<n;i++){
            vec[i]=new int[]{values[i],labels[i]};
        }
        Arrays.sort(vec, (a, b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer,Integer> mp=new HashMap<>();
        int ans=0;
        for(int i=n-1;i>=0;i--){
            int label=vec[i][1];
            int count=mp.getOrDefault(vec[i][1],0);
            if(count<useLimit){
                if(numWanted>0) ans+=vec[i][0];
                else return ans;
                numWanted--;
                mp.put(label,count+1);
            }
        }
        return ans;
    }
}