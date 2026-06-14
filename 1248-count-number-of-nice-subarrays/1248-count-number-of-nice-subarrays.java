class Solution {
    private int solve(int[] nums,int k){
        int n=nums.length;
        int i=0,j=0,count=0;
        while(j<n){
            if(nums[j]%2==1) k--;
            while(i<=j && k<0){
                if(nums[i]%2==1) k++;
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
}