class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int mxReach=0;
        int curReach=0;
        for(int i=0;i<n-1;i++){
             if(mxReach<i+nums[i]){
                mxReach=i+nums[i];
             }
             if(i==curReach){
                jumps++;
                curReach=mxReach;
             }
        }
        return jumps;
    }
}