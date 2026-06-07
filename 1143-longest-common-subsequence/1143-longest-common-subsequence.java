class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int n=t1.length();
        int m=t2.length();
        if(n==0 || m==0) return 0;
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char ch1=t1.charAt(i-1);
                char ch2=t2.charAt(j-1);
                if(ch1==ch2){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    int w1=dp[i-1][j];
                    int w2=dp[i][j-1];
                    dp[i][j]=Math.max(w1,w2);
                } 
            }
        }
        return dp[n][m];
    }
}