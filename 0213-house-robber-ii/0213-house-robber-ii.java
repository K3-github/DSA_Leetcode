class Solution {
    private int solve(int[] nums){
        int n=nums.length;
        if(n==1) return nums[0];
        int prev2=nums[0],prev=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int left=nums[i]+prev2;
            int right=prev;
            int curr=Math.max(left,right);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] nums1=new int[n-1];
        int[] nums2=new int[n-1];
        int k=0;
        for(int i=0;i<n;i++){
            if(i==0){
                nums1[i]=nums[i];
                continue;
            }
            if(i==n-1){
                nums2[k++]=nums[i];
                continue;
            }
            nums1[i]=nums[i];
            nums2[k++]=nums[i];
        }
        int w1=solve(nums1);
        int w2=solve(nums2);
        return Math.max(w1,w2);
    }
}