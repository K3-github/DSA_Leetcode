class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int ans=0;
        int n=nums.length;
        while(j<n){
            while(j<n && k>=0){
                if(nums[j]==0) k--;
                if(k>=0) ans=Math.max(ans,j-i+1);
                j++;
            }
            if(nums[i]==0) k++;
            i++;
        }
        return ans;
    }
}