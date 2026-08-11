class Solution {
    int mod=1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=i;j<n;j++){
                curr+=nums[j];
                arr.add(curr);
            }
        }
        Collections.sort(arr);
        long ans=0;
        for(int i=left;i<=right;i++){
            ans+=arr.get(i-1);
            ans=ans%mod;
        }
        return (int)ans;
    }
}