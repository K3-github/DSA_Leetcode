class Solution {
    int[] dp;
    private int solve(int ind,int[] p){
        if(ind>=p.length) return 0;
        if(dp[ind]!=-1) return dp[ind];

        int pick=p[ind]+solve(ind+2,p);
        int notPick=solve(ind+1,p);

        return dp[ind]=Math.max(pick,notPick);
    }
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int mx=0;
        for(int i=0;i<n;i++){
           mx=Math.max(mx,nums[i]);
        }
        int[] points=new int[mx+1];
        for(int i=0;i<n;i++){
            points[nums[i]]+=nums[i];
        }
        dp=new int[mx+1];
        Arrays.fill(dp,-1);
        return solve(0,points);
    }
}