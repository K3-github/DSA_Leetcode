class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid-1>=0 && mid+1<n && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if(arr[mid]<arr[mid+1]) low=mid+1;
            else high=mid-1;
        }
        return ans;
    }
}