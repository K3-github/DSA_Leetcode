/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int findPeakIndex(MountainArray mountainArr){
        int n=mountainArr.length();
        int low=0,high=n-1;
        while(low<high){
            int mid=low+(high-low)/2;
            int midEle=mountainArr.get(mid);
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                low = mid+1;
            }
            else high=mid;
        }
        return low;
    }
    private int searchInIncreasingHalf(int target, MountainArray mountainArr,int ind){
        int low=0,high=ind;
        while(low<=high){
            int mid=low+(high-low)/2;
            int midEle=mountainArr.get(mid);
            if(midEle==target) return mid;
            else if(midEle<target) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    private int searchInDecreasingHalf(int target, MountainArray mountainArr,int ind,int n){
        int low=ind,high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int midEle=mountainArr.get(mid);
            if(midEle==target) return mid;
            else if(midEle<target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
         int n=mountainArr.length();
         if(n<=2) return -1;
         int ind=findPeakIndex(mountainArr);
         System.out.println(ind);
         int left=searchInIncreasingHalf(target,mountainArr,ind);
         int right=searchInDecreasingHalf(target,mountainArr,ind,n);
         if(left!=-1) return left;
         if(right!=-1) return right;
         return -1;
    }
}