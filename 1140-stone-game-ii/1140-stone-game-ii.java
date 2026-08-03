class Solution {
    int[] psum;
    private int solve(int index,int m,int[] piles,int[][] dp){
        if(index>=piles.length) return 0;
        if(dp[index][m]!=-1) return dp[index][m];
        
        int ans=0;
        int size=psum.length;
        for(int x=1;x<=2*m;x++){
            int res=psum[size-1]-psum[index];
            int newM = Math.max(m, x);
            ans=Math.max(ans,res-solve(index+x,newM,piles,dp));
        }
        return dp[index][m]=ans;
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        psum=new int[n+1];
        for(int i=0;i<n;i++){
           psum[i+1]=piles[i]+psum[i];
        }
        int[][] dp=new int[n][200];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,1,piles,dp);
    }
}

