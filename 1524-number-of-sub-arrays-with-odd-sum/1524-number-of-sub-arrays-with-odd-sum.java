class Solution {
    public int numOfSubarrays(int[] arr) {
        int even=1,odd=0;
        int n=arr.length;
        int curr=0;
        int mod=1000000007;
        long ans=0;
        for(int i=0;i<n;i++){
            curr+=arr[i];
            if(curr%2==0){
                ans+=odd;
            }
            else ans+=even;
            ans=ans%mod;

            if(curr%2==0) even++;
            else odd++;
        }
        return (int)ans;
    }
}