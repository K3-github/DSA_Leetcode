class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long[] psum=new long[n];
        psum[0]=nums[0];
        for(int i=1;i<n;i++) psum[i]=psum[i-1]+(long)nums[i];
        for(int i=n-1;i>=2;i--){
            if(nums[i]<psum[i-1]) return psum[i];
        }
        return -1;
    }
}