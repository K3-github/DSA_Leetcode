class Solution {
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
           dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
           dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char ch1=s.charAt(i-1);
                char ch2=t.charAt(j-1);
                if(ch1==ch2) dp[i][j]=dp[i-1][j-1];
                else{
                    int w1=1+dp[i][j-1];
                    int w2=1+dp[i-1][j];
                    int w3=1+dp[i-1][j-1];
                    dp[i][j]=Math.min(w1,Math.min(w2,w3));
                }
            }
        }
        return dp[n][m];
    }
}