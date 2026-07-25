class Solution {
    public int partitionDisjoint(int[] nums) {
        int n=nums.length;
        int[] mxRight=new int[n];
        mxRight[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            mxRight[i]=Math.min(mxRight[i+1],nums[i]);
        }
        int leftMx=0;
        for(int i=0;i<n-1;i++){
            leftMx=Math.max(leftMx,nums[i]);
            if(leftMx<=mxRight[i+1]) return i+1;
        }
        return 0;
    }
}