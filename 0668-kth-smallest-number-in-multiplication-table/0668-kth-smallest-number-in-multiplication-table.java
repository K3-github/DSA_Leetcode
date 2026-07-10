class Solution {
    private int solve(int m,int n,int num){
        int row=1,col=n;
        int count=0;
        while(row<=m && col>=1){
            if(row*col<=num){
                count+=col;
                row++;
            }
            else col--;
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low=1,high=m*n;
        while(low<=high){
            int mid=low+(high-low)/2;
            int cnt=solve(m,n,mid);
            if(cnt<k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}