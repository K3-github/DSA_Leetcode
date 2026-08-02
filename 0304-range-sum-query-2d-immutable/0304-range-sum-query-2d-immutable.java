class NumMatrix {

    int[][] psum;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        psum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                psum[i][j] = matrix[i - 1][j - 1]
                           + psum[i - 1][j]
                           + psum[i][j - 1]
                           - psum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return psum[row2 + 1][col2 + 1]
             - psum[row1][col2 + 1]
             - psum[row2 + 1][col1]
             + psum[row1][col1];
    }
}