class Solution {
    private int bsearch(int[] nums,int x){
        int low=0,high=nums.length-1;
        if(nums[low]>x) return low;
        if(nums[high]<x) return high+1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=x) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        long[] psum=new long[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+nums[i];
        }
        List<Long> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int ind=bsearch(nums,queries[i]);
            Long left=(long)ind*(long)queries[i]-(long)psum[ind];
            Long right=(long)(psum[n]-psum[ind])-(n-ind)*(long)queries[i];
            ans.add(left+right);
        }
        return ans;
    }
}