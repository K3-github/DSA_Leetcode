class Solution {
    int[] psum;
    private int solve(int left,int right,int[] stones,int[][] dp){
        if(left==right) return 0;
        if(dp[left][right]!=-1) return dp[left][right]; 
        
        int leftScore=psum[right]-psum[left];
        int rightScore=psum[right-1]-(left>0 ? psum[left-1] : 0);

        int pickLeft=leftScore-solve(left+1,right,stones,dp);
        int pickRight=rightScore-solve(left,right-1,stones,dp);

        return dp[left][right]=Math.max(pickLeft,pickRight);
    }
    public int stoneGameVII(int[] stones) {
        int n=stones.length;
        psum=new int[n];
        psum[0]=stones[0];
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=1;i<n;i++){
            psum[i]=stones[i]+psum[i-1];
        }
        return solve(0,n-1,stones,dp);
    }
}