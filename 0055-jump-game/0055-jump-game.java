class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        int mxReach=0,currReach=0;
        for(int i=0;i<n;i++){
            if(i>mxReach) return false;
            mxReach=Math.max(mxReach,i+nums[i]);
        }
        return true;
    }
}