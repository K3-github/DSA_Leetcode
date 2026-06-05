class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=10000000;
            }
        }
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=0;j<triangle.get(i).size();j++){
                  int left=10000000;
                  if(j>0) left=dp[i-1][j-1];
                  int right=dp[i-1][j];
                  dp[i][j]=triangle.get(i).get(j)+Math.min(left,right);
            }
        }
        int ans=10000000;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }
}