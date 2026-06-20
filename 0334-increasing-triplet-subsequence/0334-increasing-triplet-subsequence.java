class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        if(n<3) return false;
        int[] sMax=new int[n];
        sMax[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            sMax[i]=Math.max(sMax[i+1],nums[i]);
        }
        int pMin=nums[0];
        for(int i=1;i<n-1;i++){
            if(nums[i]>pMin && nums[i]<sMax[i]) return true;
            pMin=Math.min(pMin,nums[i]);
        }
        return false;
    }
}