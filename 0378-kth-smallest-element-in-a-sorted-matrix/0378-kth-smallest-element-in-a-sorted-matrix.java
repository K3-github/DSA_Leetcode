class Solution {
    private int solve(int[][] mat,int mid){
         int n=mat.length;
         int row=0,col=n-1;
         int count=0;
         while(row<n && col>=0){
            if(mat[row][col]<=mid){
                count+=col+1;
                row++;
            }
            else col--;
         }
         return count;
    }
    public int kthSmallest(int[][] mat, int k) {
        int n=mat.length;
        int low=mat[0][0],high=mat[n-1][n-1];

        while(low<=high){
            int mid=low+(high-low)/2;
            int count=solve(mat,mid);
            if(count<k){
                low=mid+1;
            }
            else high=mid-1;
        }
        return low;
    }
}