class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0,right=0;
        int n=nums.length;
        while(right<n){
            int count=1;
            nums[left++]=nums[right];
            while(right<n-1 && nums[right]==nums[right+1]){
                count++;
                if(count<=2) nums[left++]=nums[right];
                right++;
            }
            right++;
        }
        return left;
    }
}