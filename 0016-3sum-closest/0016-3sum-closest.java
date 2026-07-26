class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        int diff=Integer.MAX_VALUE;
        for(int curr=n-1;curr>=2;curr--){
            int left=0,right=curr-1;
            int up_t=target-nums[curr];
            while(left<right){
                int sum=nums[left]+nums[right];
                if(Math.abs(up_t-sum)<diff){
                    ans=nums[curr]+nums[left]+nums[right];
                    diff=Math.abs(up_t-sum);
                }
                if(sum==up_t) return target;
                else if(sum<up_t){
                   left++;
                }
                else right--;
            }
        }
        return ans;
    }
}