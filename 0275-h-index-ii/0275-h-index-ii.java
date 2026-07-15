class Solution {
    private boolean isPossible(int[] cit,int ele){
        int low=0,high=cit.length-1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(cit[mid]>=ele){
                high=mid-1;
            }
            else low=mid+1;
        }
        return cit.length-low>=ele;
    } 
    public int hIndex(int[] citations) {
        int low=0,high=1001;
        while(low<=high){
            int h=(low+high) >> 1;
            if(isPossible(citations,h)==true){
                low=h+1;
            }
            else high=h-1;
        }
        return high;
    }
}