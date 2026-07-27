class Solution {
    public int maxProduct(int[] nums) {
        int fmx=-1,smx=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>fmx){
                smx=fmx;
                fmx=nums[i];
            }
            else if(nums[i]>smx){
                smx=nums[i];
            }
        }
        return (fmx-1)*(smx-1);
    }
}