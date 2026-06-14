class Solution {
    private int countSubarraySumGreaterThanOrEqualGoal(int[] nums,int goal){
       int n=nums.length;
       int i=0,j=0,count=0,sum=0;
       while(j<n){
           sum+=nums[j];
           while(i<=j && sum>=goal){
              count+=n-j;
              sum-=nums[i++];
           }
           j++;
       }
       return count;
    }
    private int countSubarraySumGreaterThanGoal(int[] nums,int goal){
       int n=nums.length;
       int i=0,j=0,count=0,sum=0;
       while(j<n){
           sum+=nums[j];
           while(i<=j && sum>goal){
              count+=n-j;
              sum-=nums[i++];
           }
           j++;
       }
       return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarraySumGreaterThanOrEqualGoal(nums,goal)
                -countSubarraySumGreaterThanGoal(nums,goal);
    }
}