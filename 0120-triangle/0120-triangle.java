class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] dp=new int[n];
        
        dp[0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                  int left=10000000,right=10000000;
                  if(j>0) left=dp[j-1];
                  if(j<i) right=dp[j];
                  dp[j]=triangle.get(i).get(j)+Math.min(left,right);
            }
        }
        int ans=10000000;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[i]);
        }
        return ans;
    }
}