class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        int[] deg=new int[n];
        for(int[] e: edges){
           deg[e[0]-1]++;
           deg[e[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(deg[i]==n-1) return i+1;
        }
        return -1;
    }
}