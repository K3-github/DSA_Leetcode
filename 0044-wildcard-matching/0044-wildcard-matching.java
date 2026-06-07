class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            dp[i][0]=false;
        }
        for(int j=1;j<=m;j++){
            boolean flag=true;
            for(int ptr=j;ptr>=1;ptr--){
                if(p.charAt(ptr-1)!='*'){
                    flag=false;
                    break;
                }
            }
            dp[0][j]=(flag==true ? true : false);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char ch1=s.charAt(i-1);
                char ch2=p.charAt(j-1);
                if(ch1==ch2 || ch2=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(ch2=='*'){
                    boolean w1=dp[i-1][j];
                    boolean w2=dp[i][j-1];
                    dp[i][j]=w1 || w2;
                }
                else dp[i][j]=false;
            }
        }
        return dp[n][m];
    }
}