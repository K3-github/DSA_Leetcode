class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n=nums.length;
        int mod=1000000007;
        int[] diff=new int[n+1];

        for(int[] request:requests){
            int start=request[0];
            int end=request[1];

            diff[start]++;
            diff[end+1]--;
        }
        int[] freq=new int[n];
        int curr=0;

        for(int i=0;i<n;i++){
            curr+=diff[i];
            freq[i]=curr;
        }
        Arrays.sort(nums);
        Arrays.sort(freq);

        long ans=0;
        for(int i=0;i<n;i++){
            ans+=(long)nums[i]*freq[i];
            ans%=mod;
        }
        return (int)ans;
    }
}