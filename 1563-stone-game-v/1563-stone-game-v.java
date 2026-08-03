class Solution {
    int[] psum;
    private int solve(int left,int right,int[][] dp){
        if(left==right) return 0;
        if(dp[left][right]!=-1) return dp[left][right]; 
        
        int ans=0;
        for(int part=left;part<right;part++){
             int ls=psum[part+1]-psum[left];
             int rs=psum[right+1]-psum[part+1];
             if(ls>rs){
                ans=Math.max(ans,rs+solve(part+1,right,dp));
             }
             else if(ls<rs){
                ans=Math.max(ans,ls+solve(left,part,dp));
             }
             else{
                ans=Math.max(ls+solve(left,part,dp),rs+solve(part+1,right,dp));
             }
        }
        return dp[left][right]=ans;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        psum=new int[n+1];
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            psum[i+1]=stoneValue[i]+psum[i];
        }
        return solve(0,n-1,dp);
    }
}