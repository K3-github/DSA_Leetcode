class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] dp=new int[m+1];
        for(int i=0;i<=n;i++) dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                char ch1=s.charAt(i-1);
                char ch2=t.charAt(j-1);
                if(ch1==ch2){
                    int w1=dp[j-1];
                    int w2=dp[j];
                    dp[j]= w1+w2;
                }
            }
        }
        return dp[m];
    }
}