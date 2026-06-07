class Solution {
    private int solve(int i,int j,String s,String t,int[][] dp){
        if(j<0) return i+1;
        if(i<0) return j+1;
        if(dp[i][j]!=-1) return dp[i][j];

        char ch1=s.charAt(i);
        char ch2=t.charAt(j);
        if(ch1==ch2) return dp[i][j]=solve(i-1,j-1,s,t,dp);
        else{
            int w1=1+solve(i,j-1,s,t,dp);
            int w2=1+solve(i-1,j,s,t,dp);
            int w3=1+solve(i-1,j-1,s,t,dp);
            return dp[i][j]=Math.min(w1,Math.min(w2,w3));
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(n-1,m-1,word1,word2,dp);
    }
}