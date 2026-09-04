class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] rightMn=new int[n];
        rightMn[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightMn[i]=Math.min(rightMn[i+1],nums[i]);
        }
        int leftMx=0;
        for(int i=0;i<n;i++){
            leftMx=Math.max(leftMx,nums[i]);
            int diff=leftMx-rightMn[i];
            if(diff<=k) return i;
        }
        return -1;
    }
}