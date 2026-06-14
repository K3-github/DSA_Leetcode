class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0,n=nums.length;
        for(int i=0;i<n;i++) sum+=nums[i];
        int target=sum-x;
        if(target==0) return n;
        int i=0,j=0,ans=0;
        int curr=0;
        while(j<n){
             curr+=nums[j];
             while(i<=j && curr>target){
                curr-=nums[i++];
             }
             if(curr==target) ans=Math.max(ans,j-i+1);
             j++;
        }
        return ans==0 ? -1 : n-ans;
    }
}