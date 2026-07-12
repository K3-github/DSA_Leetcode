class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        if(n==0) return new int[]{};
        int[][] v=new int[n][2];
        for(int i=0;i<n;i++){
            v[i]=new int[]{arr[i],i};
        }
        Arrays.sort(v,(a,b) -> a[0]-b[0]);
        int[] rank=new int[n];
        int prev=1;
        rank[v[0][1]]=prev;
        for(int i=1;i<n;i++){
            if(v[i][0]!=v[i-1][0]) prev++;
            rank[v[i][1]]=prev;
        }
        return rank;
    }
}