class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int prev2=nums[0],prev=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int left=nums[i]+prev2;
            int right=prev;
            int curr=Math.max(left,right);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}