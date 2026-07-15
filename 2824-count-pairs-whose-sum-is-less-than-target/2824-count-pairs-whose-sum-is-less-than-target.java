class Solution {
    private int solve(List<Integer> nums,int limit){
        int i=0,j=nums.size()-1;
        int count=0;
        while(i<j){
             if(nums.get(i)+nums.get(j)<limit){
                 count+=j-i;
                 i++;
             }
             else j--;
        }
        return count;
    }
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        return solve(nums,target);
    }
}