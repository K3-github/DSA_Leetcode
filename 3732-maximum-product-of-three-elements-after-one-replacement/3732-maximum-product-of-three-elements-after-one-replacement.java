class Solution {
    public long maxProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        long res1=(long)nums[n-1]*(long)nums[n-2]*(100000);
        long res2=(long)nums[0]*(long)nums[1]*(100000);
        long res3=(long)nums[0]*(long)nums[n-1]*(-100000);
        return Math.max(res1,Math.max(res2,res3));
    }
}