class Solution {
    private int solve(int pos,int mask,int n,int[][] dp){
        if(pos==n) return 1;
        if(dp[pos][mask]!=-1) return dp[pos][mask];
        int ans=0;
        for(int digit=0;digit<=9;digit++){
            if(mask==0 && digit==0){
               ans+=solve(pos+1,mask,n,dp);
            }
            else{
                if((mask & (1<<digit))!=0) continue;
                int newMask=mask | (1<<digit);
                ans+=solve(pos+1,newMask,n,dp);
            }
        }
        return dp[pos][mask]=ans;
    }
    public int countNumbersWithUniqueDigits(int n) {
        int[][] dp=new int[n][1<<10];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,n,dp);
    }
}
