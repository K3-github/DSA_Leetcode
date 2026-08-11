class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1)sum+=nums[i];
            else break;
        }
        boolean a = true;
        while(a){
            a = false;

        for(int i=0;i<nums.length ;i++){
            if(sum==nums[i]){
                sum++;
                a=true;
                break;
            }
        }
        }
        return sum;
    }
}