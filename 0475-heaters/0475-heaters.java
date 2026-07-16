class Solution {
    private int binarySearch(int[] h,int x){
        int low=0,high=h.length-1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(h[mid]>=x) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int findRadius(int[] houses, int[] heaters) {
        int n=houses.length;
        Arrays.sort(heaters);
        int ans=0;
        for(int i=0;i<n;i++){
            int ind=binarySearch(heaters,houses[i]);
            int left=Integer.MAX_VALUE;
            int right=Integer.MAX_VALUE;

            if(ind>0){
                left=houses[i]-heaters[ind-1];
            }
            if(ind<heaters.length){
                right=heaters[ind]-houses[i];
            }
            ans=Math.max(ans,Math.min(left,right));
        }
        return ans;
    }
}