class Solution {
    private int solve(int ind,int[] nums,int k,int[] dp){
        int n=nums.length;
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int len=0;
        for(int j=ind;j<n;j++){
            if(mp.containsKey(nums[j])){
                int freq=mp.get(nums[j])+1;
                mp.put(nums[j],freq);
                if(freq==2) len+=2;
                else len++;
            }
            else{
                mp.put(nums[j],1);
            }
            int res=solve(j+1,nums,k,dp);
            if(res!=Integer.MAX_VALUE){
                ans=Math.min(ans,k+len+res);
            }
        }
        return dp[ind]=ans;
    }
    public int minCost(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,nums,k,dp);
    }
}