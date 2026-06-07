class Solution {
    private int solve(int i,int j,String s,String t,int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        char ch1=s.charAt(i);
        char ch2=t.charAt(j);
        if(ch1==ch2){
            int w1=solve(i-1,j-1,s,t,dp);
            int w2=solve(i-1,j,s,t,dp);
            return dp[i][j]=w1+w2;
        }
        else{
            return dp[i][j]=solve(i-1,j,s,t,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
                // char ch1=s.charAt(i);
                // char ch2=t.charAt(j);
                // if(ch1==ch2){
                //     int w1=dp[i-1][j-1];
                //     int w2=dp[i-1][j];
                //     dp[i][j]= w1+w2;
                // }
                // else{
                //     dp[i][j]=solve(i-1,j,s,t,dp);
                // }
            }
        }
        return solve(n-1,m-1,s,t,dp);
    }
}