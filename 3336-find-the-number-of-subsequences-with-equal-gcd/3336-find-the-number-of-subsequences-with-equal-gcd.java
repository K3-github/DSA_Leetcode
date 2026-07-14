class Solution {
    int mod=1000000007;
    private int getGcd(int a,int b){
        if(b==0) return a;
        return getGcd(b,a%b);
    }
    private int solve(int ind,int gcd1,int gcd2,int[] nums,int[][][] dp){
        if(ind>=nums.length){
            if((gcd1!=0 && gcd2!=0 && gcd1==gcd2)) return 1;
            return 0;
        }
        if(dp[ind][gcd1][gcd2]!=-1) return dp[ind][gcd1][gcd2];

        int updated_gcd1=getGcd(gcd1,nums[ind]);
        int updated_gcd2=getGcd(gcd2,nums[ind]);
        
        long ans=0;
        ans+=solve(ind+1,updated_gcd1,gcd2,nums,dp);
        ans+=solve(ind+1,gcd1,updated_gcd2,nums,dp);
        ans+=solve(ind+1,gcd1,gcd2,nums,dp);
        return dp[ind][gcd1][gcd2]=(int)(ans%mod);
    }
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;
        int mx=0;
        for(int i=0;i<n;i++) mx=Math.max(mx,nums[i]);
        int[][][] dp=new int[n][mx+1][mx+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<mx+1;j++){
                for(int k=0;k<mx+1;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(0,0,0,nums,dp);
    }
}