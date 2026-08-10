class Solution {
    int[][] psum;
    private void calPsum(int[][] mat,int n,int m){
       for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                 psum[i+1][j+1]=psum[i+1][j]+psum[i][j+1]-psum[i][j]+mat[i][j];
            }
        }
    }
    private boolean isPossible(int k, int n, int m) {
        int minRow = n, maxRow = -1;
        int minCol = m, maxCol = -1;

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int sum = psum[i][j]
                        - psum[i-k][j]
                        - psum[i][j-k]
                        + psum[i-k][j-k];

                if (sum == k * k) {
                    int row = i - k;
                    int col = j - k;

                    minRow = Math.min(minRow, row);
                    maxRow = Math.max(maxRow, row);

                    minCol = Math.min(minCol, col);
                    maxCol = Math.max(maxCol, col);

                    if (maxRow - minRow >= k ||
                        maxCol - minCol >= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public int maxArea(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        psum=new int[n+1][m+1];
        calPsum(mat,n,m);
        
        int low=0;
        int high = Math.min(n, m);
        while(low<=high){
            int mid=(low+high) >> 1;
            if(isPossible(mid,n,m)){
                low=mid+1;
            }
            else high=mid-1;
        }
        return high*high;
    }
}