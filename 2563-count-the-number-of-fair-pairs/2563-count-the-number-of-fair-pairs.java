class Solution {
    private long countPairs(int[] nums,int limit){
        int n=nums.length;
        int i=0,j=n-1;
        long count=0;
        while(i<j){
            if(nums[i]+nums[j]>limit){
                j--;
            }
            else{
                count+=j-i;
                i++;
            }
        }
        return count;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums,upper)-countPairs(nums,lower-1);
    }
}