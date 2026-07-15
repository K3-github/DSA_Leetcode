class Solution {
    private int binarySearch2(int[] nums,int x,int ind){
        int ans=-1,n=nums.length;
        int low=ind,high=n-1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(nums[mid]<=x){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
    private int binarySearch1(int[] nums,int x,int ind){
        int ans=-1,n=nums.length;
        int low=ind,high=n-1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(nums[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        long count=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int start=binarySearch1(nums,lower-nums[i],i+1);
            int end=binarySearch2(nums,upper-nums[i],i+1);
            if(start!=-1 && end!=-1) count+=end-start+1;
        }
        return count;
    }
}