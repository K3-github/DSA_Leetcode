class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        int n=nums.length;
        long ans=0;
        for(int i=n-1;i>=0;i--){
            if(mul>0) ans=ans+((long)nums[i]*(long)mul);
            else ans=ans+(long)nums[i];
            mul--;
            k--;
            if(k==0) return ans;
        }
        return ans;
    }
}
