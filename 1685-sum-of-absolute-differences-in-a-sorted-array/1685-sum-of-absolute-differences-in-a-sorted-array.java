class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;

        int[] psum=new int[n+1];

        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+nums[i];
        }

        int[] result=new int[n];

        for(int i=0;i<n;i++){
            int leftCount=i;
            int leftSum=psum[i];

            int rightCount=n-i-1;
            int rightSum=psum[n]-psum[i+1];
            
            int left=nums[i]*leftCount-leftSum;
            int right=rightSum-nums[i]*rightCount;

            result[i]=left+right;
        }
        return result;
    }
}