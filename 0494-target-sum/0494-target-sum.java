class Solution {
    private int solve(int ind,int curr,int target,int[] nums){
        if(ind<0){
            return curr==target ? 1 : 0;
        }
        int w1=solve(ind-1,curr+nums[ind],target,nums);
        int w2=solve(ind-1,curr-nums[ind],target,nums);

        return w1+w2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return solve(n-1,0,target,nums);
    }
}