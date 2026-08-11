class Solution {
    int ans=0;
    private void solve(int ind,int xor,int[] nums){
        if(ind>=nums.length){
            ans+=xor;
            return;
        }
        solve(ind+1,nums[ind]^xor,nums);
        solve(ind+1,xor,nums);
    }
    public int subsetXORSum(int[] nums) {
        solve(0,0,nums);
        return ans;
    }
}