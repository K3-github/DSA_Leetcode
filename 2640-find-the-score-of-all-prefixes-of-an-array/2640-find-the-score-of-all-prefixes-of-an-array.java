class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n=nums.length;
        int[] con=new int[n];
        int mx=-1;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            con[i]=nums[i]+mx;
        }
        long[] psum=new long[n];
        psum[0]=con[0];
        for(int i=1;i<n;i++){
            psum[i]=psum[i-1]+con[i];
        }
        return psum;
    }
}