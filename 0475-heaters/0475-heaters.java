class Solution {

    private int binarySearch(int[] heaters,int house){
        int low=0,high=heaters.length-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(heaters[mid]>=house){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans=0;
        for(int house:houses){
            int ind=binarySearch(heaters,house);
            int left=Integer.MAX_VALUE;
            int right=Integer.MAX_VALUE;

            if(ind>0){
                left=house-heaters[ind-1];
            }
            if(ind<heaters.length){
                right=heaters[ind]-house;
            }
            ans=Math.max(ans,Math.min(left,right));
        }
        return ans;
    }
}