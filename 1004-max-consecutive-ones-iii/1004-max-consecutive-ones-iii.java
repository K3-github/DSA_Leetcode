class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int ans=0;
        int n=nums.length;
        while(j<n){
            while(j<n && (nums[j]==1 || k>0)){
                if(nums[j]==0) k--;
                ans=Math.max(ans,j-i+1);
                j++;
            }
            while(k<=0 && i<n){
                if(nums[i]==0) k++;
                i++;
            }
        }
        return ans;
    }
}