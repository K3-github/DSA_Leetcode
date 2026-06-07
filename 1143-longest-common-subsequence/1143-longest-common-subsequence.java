class Solution {
    private int solve(int i,int j,String t1,String t2,int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        char ch1=t1.charAt(i);
        char ch2=t2.charAt(j);
        if(ch1==ch2){
            return dp[i][j]=1+solve(i-1,j-1,t1,t2,dp);
        }
        else{
            int w1=solve(i-1,j,t1,t2,dp);
            int w2=solve(i,j-1,t1,t2,dp);
            return dp[i][j]=Math.max(w1,w2);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        if(n==0 || m==0) return 0;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(n-1,m-1,text1,text2,dp);
    }
}