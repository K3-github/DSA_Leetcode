class Solution {
    int ans=0;
    private int solve(int ind,int xor,int[] nums){
        if(ind>=nums.length) return xor;
        return solve(ind+1,nums[ind]^xor,nums)+solve(ind+1,xor,nums);
    }
    public int subsetXORSum(int[] nums) {
        return solve(0,0,nums);
    }
}