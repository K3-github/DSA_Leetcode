class Solution {
    private int cal(int[] nums,int sum){
        int cap=sum;
        int chunks=1;
        for(int i=0;i<nums.length;i++){
            if(cap>=nums[i]){
                cap-=nums[i];
            }
            else{
                cap=sum;
                cap-=nums[i];
                chunks++;
            }
        }
        return chunks;
    }
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
          low=Math.max(low,nums[i]);
          high+=nums[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int chunks=cal(nums,mid);
            if(chunks<=k){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}