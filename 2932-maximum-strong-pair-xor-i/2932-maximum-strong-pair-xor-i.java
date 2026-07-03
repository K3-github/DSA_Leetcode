class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x=nums[i],y=nums[j];
                if(Math.abs(x-y)<=Math.min(x,y)){
                    ans=Math.max(ans,x^y);
                }
            }
        }
        return ans;
    }
}