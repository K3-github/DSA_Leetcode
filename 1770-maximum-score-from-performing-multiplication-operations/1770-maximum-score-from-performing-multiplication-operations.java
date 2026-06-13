class Solution {
    private int solve(int i,int j,int ind,int[] multipliers,int[] nums,int[][][] dp){
        int m=multipliers.length;
        int n=nums.length;
        if(ind>=m) return 0;
        if(dp[i][j-n+m][ind]!=-1) return dp[i][j-n+m][ind];

        int w1=multipliers[ind]*nums[i]+solve(i+1,j,ind+1,multipliers,nums,dp);
        int w2=multipliers[ind]*nums[j]+solve(i,j-1,ind+1,multipliers,nums,dp);

        return dp[i][j-n+m][ind]=Math.max(w1,w2);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length;
        int m=multipliers.length;
        int[][][] dp=new int[m][m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                for(int k=0;k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(0,n-1,0,multipliers,nums,dp);
    }
}