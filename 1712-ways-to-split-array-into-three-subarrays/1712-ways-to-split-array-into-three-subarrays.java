class Solution {
    public int waysToSplit(int[] nums) {
        int n=nums.length;
        int mod=1000000007;
        long[] psum=new long[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+nums[i];
        }
        long ans=0;
        for(int i=0;i<n-2;i++){
            long first=psum[i+1];
            int low=i+1,high=n-2;
            int firstJ=n;
            while(low<=high){
                int mid=(low+high)/2;
                long second=psum[mid+1]-first;
                if(second>=first){
                    firstJ=mid;
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            low=i+1;
            high=n-2;
            int lastJ=i;
            while(low<=high){
                int mid=(low+high)/2;

                long second=psum[mid+1]-first;
                long third=psum[n]-psum[mid+1];

                if(second<=third){
                    lastJ=mid;
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            if(firstJ<=lastJ){
                ans=(ans+(lastJ-firstJ+1))%mod;
            }
        }
        return (int)ans;
    }
}