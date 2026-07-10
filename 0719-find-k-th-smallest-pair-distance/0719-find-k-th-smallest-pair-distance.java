class Solution {
    private int noOfPairs(int[] nums,int dis){
        int n=nums.length;
        int count=0;
        int j=1;
        for(int i=0;i<n;i++){
           while(j<n && nums[j]-nums[i]<=dis){
               j++;
           }
           count+=j-i-1;
        }
        return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low=Integer.MAX_VALUE,high;
        int n=nums.length;
        for(int i=1;i<n;i++){
           low=Math.min(low,nums[i]-nums[i-1]);
        }
        high=nums[n-1]-nums[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            int cnt=noOfPairs(nums,mid);
            if(cnt>=k){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}