class Solution {
    public int[] findDegrees(int[][] mat) {
        int n=mat.length;
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    ans[i]++;
                    ans[j]++;
                }
            }
        }
        for(int i=0;i<n;i++) ans[i]/=2;
        return ans;
    }
}