class Solution {
    private void shiftRowElementByOne(int[][] grid,int col){
        int n=grid.length;
        int last=grid[n-1][col];
        for(int row=n-1;row>=1;row--){
            grid[row][col]=grid[row-1][col];
        }
        grid[0][col]=last;
    }
    private void swap(int[][] grid,int col1,int col2){
        int n=grid.length;
        for(int row=0;row<n;row++){
            int temp=grid[row][col1];
            grid[row][col1]=grid[row][col2];
            grid[row][col2]=temp;
        }
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        k %= (n * m);
        while(k>0){ 
            for(int col=m-1;col>=1;col--){
                swap(grid,col,col-1);
            }
            shiftRowElementByOne(grid,0);
            k--;
        }
        return Arrays.stream(grid)
                     .map(row -> Arrays.stream(row)
                          .boxed()
                          .collect(Collectors.toList()))
                          .collect(Collectors.toList());
    }
}