class Solution {
    private void rev(int[] right){
        int i=0,j=right.length-1;
        while(i<j){
            int tp=right[i];
            right[i]=right[j];
            right[j]=tp;
            i++;j--;
        }
        return;
    }
    public int longestMountain(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];

        for(int i=0;i<n;i++){
            left[i]=1;
            right[i]=1;
        }
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                left[i]+=left[i-1];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                right[i]+=right[i+1];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(left[i]==1 || right[i]==1) continue;
            ans=Math.max(ans,left[i]+right[i]-1);
        }
        return ans;
    }
}