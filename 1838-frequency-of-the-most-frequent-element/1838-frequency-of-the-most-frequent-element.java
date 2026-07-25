class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=n-1,right=n-1;
        int currSum=0;
        int ans=0;
        while(left>=0){
            currSum+=nums[left];
            while(right>left && (((right-left+1)*nums[right])-currSum)>k){
                   currSum-=nums[right];
                   right--;
            }
            ans=Math.max(ans,right-left+1);
            left--;
        }
        return ans;
    }
}