class Solution {
    public int longestMountain(int[] arr) {
        int n=arr.length;
        if(n<=2) return 0;
        int ans=0;
        for(int i=1;i<n-1;i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                int j=i;
                while(j>0 && arr[j-1]<arr[j]){
                    j--;
                }
                int k=i;
                while(k<n-1 && arr[k+1]<arr[k]){
                    k++;
                }
                ans=Math.max(ans,k-j+1);
            }
        }
        return ans;
    }
}