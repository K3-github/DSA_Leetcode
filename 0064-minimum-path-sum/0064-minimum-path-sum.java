class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n];
        prev[0]=grid[0][0];
        for(int j=1;j<n;j++){
            prev[j]=grid[0][j]+prev[j-1];
        }
        for(int i=1;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                  if(j==0) curr[j]=grid[i][j]+prev[j];
                  else{
                    curr[j]=grid[i][j]+Math.min(prev[j],curr[j-1]);
                  }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}