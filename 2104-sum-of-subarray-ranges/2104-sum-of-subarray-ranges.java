class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long ans=0;
        for(int i=0;i<n;i++){
            int mn=nums[i],mx=nums[i];
            ans+=mx-mn;
            for(int j=i+1;j<n;j++){
                 mn=Math.min(mn,nums[j]);
                 mx=Math.max(mx,nums[j]);
                 ans+=mx-mn;
            }
        }
        return ans;
    }
}