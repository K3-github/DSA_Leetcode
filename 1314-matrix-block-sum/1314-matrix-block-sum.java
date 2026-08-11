class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] psum=new int[n+1][m+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                psum[i+1][j+1]=psum[i+1][j]+psum[i][j+1]-psum[i][j]+mat[i][j];
            }
        }
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int r1=Math.max(0,i-k);
                int r2=Math.min(n-1,i+k);
                int c1=Math.max(0,j-k);
                int c2=Math.min(m-1,j+k);
                r2++;c2++;
                ans[i][j]=psum[r2][c2]-psum[r1][c2]-psum[r2][c1]+psum[r1][c1];
            }
        }
        return ans;
    }
}