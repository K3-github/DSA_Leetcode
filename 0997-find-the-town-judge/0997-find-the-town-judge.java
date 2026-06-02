class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind=new int[n];
        int[] out=new int[n];

        for(int[] e: trust){
            ind[e[1]-1]++;
            out[e[0]-1]++;
        }
        for(int i=0;i<n;i++){
            if(out[i]==0 && ind[i]==n-1) return i+1;
        }
        return -1;
    }
}