class NumMatrix {
    
    int[][] psum;
    public NumMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        psum=new int[n][m];
        for(int i=0;i<n;i++){
          psum[i][0]=mat[i][0];
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                psum[i][j]=psum[i][j-1]+mat[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans=0;
        for(int i=row1;i<=row2;i++){
            ans+=psum[i][col2]-(col1>0 ? psum[i][col1-1] : 0);
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */