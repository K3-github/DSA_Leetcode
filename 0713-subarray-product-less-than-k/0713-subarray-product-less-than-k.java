class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0) return 0;
        int n=nums.length,count=0,i=0,j=0,prod=1;
        while(j<n){
             prod*=nums[j];
             while(i<=j && prod>=k){
                prod/=nums[i++];
             }
             count+=j-i+1;
             j++;
        }
        return count;
    }
}