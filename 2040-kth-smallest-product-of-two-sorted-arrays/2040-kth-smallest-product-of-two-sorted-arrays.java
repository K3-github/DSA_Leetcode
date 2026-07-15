class Solution {
    private long floorDiv(long a,long b){
        long q=a/b;
        long r=a%b;
        if(r!=0 && ((a<0) ^ (b<0))){
            q--;
        }
        return q;
    }
    private long ceilDiv(long a,long b){
        long q=a/b;
        long r=a%b;
        if(r!=0 && !((a<0) ^ (b<0))){
            q++;
        }
        return q;
    }
    private int firstGreaterEqual(int[] nums,long target){
        int low=0,high=nums.length-1;
        int ans=nums.length;
        while(low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private int lastLessEqual(int[] nums,long target){
        int low=0,high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)>>1;

            if(nums[mid]<=target){
                ans=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    private long count(long x,int[] nums1,int[] nums2){
        long cnt=0;
        for(int num:nums1){
            if(num>0){
                long limit=floorDiv(x,num);
                int ind=lastLessEqual(nums2,limit);
                cnt+=ind+1;
            }
            else if(num<0){
                long limit=ceilDiv(x,num);
                int ind=firstGreaterEqual(nums2,limit);
                cnt+=nums2.length-ind;
            }
            else{
                if(x>=0){
                    cnt+=nums2.length;
                }
            }
        }
        return cnt;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low=-10000000000L;
        long high=10000000000L;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(count(mid,nums1,nums2)>=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }
}