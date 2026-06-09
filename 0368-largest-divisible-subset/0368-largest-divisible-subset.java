class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        int[] par=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            par[i]=i;
        }
        int st=0;
        int ans=1;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    if(dp[i]<1+dp[j]){
                        dp[i]=Math.max(dp[i],1+dp[j]);
                        par[i]=j;
                    }
                }
            }
            if(ans<dp[i]){
                ans=dp[i];
                st=i;
            }
        }
        List<Integer> res=new ArrayList<>();
        int ind=st;
        while(par[ind]!=ind){
            res.add(nums[ind]);
            ind=par[ind];
        }
        res.add(nums[ind]);
        return res;
    }
}