class Solution {
    public int waysToSplitArray(int[] nums) {
        long tsum=0;
        int n=nums.length;
        for(int num: nums){
            tsum+=num;
        }

        int count=0;
        long left=0;
        for(int i=0;i<n-1;i++){
            left+=nums[i];
            long right=tsum-left;
            if(left>=right) count++;
        }
        return count;
    }
}