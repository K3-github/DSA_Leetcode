class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int n=arr.length;
        long ans=0;
        int mod=1000000007;
        for(int curr=n-1;curr>=2;curr--){
            int left=0,right=curr-1;
            int remTarget=target-arr[curr];
            while(left<right){
                int sum=arr[left]+arr[right];
                if(sum==remTarget){
                   if(arr[left]==arr[right]){
                       int m=right-left+1;
                       ans+=m*(m-1)/2;
                       ans=ans%mod;
                       right=left-1;
                   }
                   else{
                       int r=1,l=1;
                       while(right>0 && arr[right]==arr[right-1]){
                            right--;r++;
                       }
                       while(left<n && arr[left]==arr[left+1]){
                            left++;l++;
                       }
                       ans+=r*l;
                       ans=ans%mod;
                       left++;right--;
                   }

                }
                else if(sum<remTarget) left++;
                else right--;
            }
        }
        return (int)ans;
    }
}