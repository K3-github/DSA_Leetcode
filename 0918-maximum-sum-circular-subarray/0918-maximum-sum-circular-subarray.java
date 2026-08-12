class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int mx=-100000;
        int sum=0;
        int total=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            mx=Math.max(mx,sum);
            if(sum<0) sum=0;
            total+=nums[i];
        }
        int mn=100000;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            mn=Math.min(mn,sum);
            if(sum>0) sum=0;
        }
        if(mx<0) return mx;
        return Math.max(mx,total-mn);
    }
}