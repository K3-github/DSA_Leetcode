class Solution {
    private void rev(int[] nums){
        int i=0,j=nums.length-1;
        while(i<j){
            int tp=nums[j];
            nums[j]=nums[i];
            nums[i]=tp;
            i++;j--;
        }
        return;
    }
    private void solve(int[] nums,int[] arr,int n){
        for(int i=0;i<n;i++){
            arr[i]=1;
        }
        for(int curr=0;curr<n;curr++){
            for(int prev=curr-1;prev>=0;prev--){
                if(nums[curr]>nums[prev]){
                    arr[curr]=Math.max(arr[curr],1+arr[prev]);
                }
            }
        }
        return;
    }
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        solve(nums,left,n);
        rev(nums);
        solve(nums,right,n);
        rev(right);
        int ans=0;
        for(int i=0;i<n;i++){
            if(left[i]==1 || right[i]==1) continue;
            ans=Math.max(ans,left[i]+right[i]-1);
        }
        return n-ans;
    }
}