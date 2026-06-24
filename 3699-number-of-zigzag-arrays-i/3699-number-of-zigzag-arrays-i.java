class Solution {
    int mod=1000000007;
    public int zigZagArrays(int n,int l,int r){
        int m=r-l+1;
        long[][] dp=new long[m+1][2];
        for(int i=1;i<=m;i++){
            dp[i][0]=1;
            dp[i][1]=1;
        }
        for(int len=1;len<n;len++){
            long[][] next=new long[m+1][2];
            long[] inc=new long[m+2];
            long[] dec=new long[m+2];
            for(int i=1;i<=m;i++){
                inc[i]=(inc[i-1]+dp[i][0])%mod;
                dec[i]=(dec[i-1]+dp[i][1])%mod;
            }
            for(int i=1;i<=m;i++){
                next[i][0]=(dec[m]-dec[i]+mod)%mod;
                next[i][1]=inc[i-1];
            }
            dp=next;
        }
        long ans=0;
        for(int i=1;i<=m;i++){
            ans+=dp[i][0];
            ans+=dp[i][1];
            ans%=mod;
        }
        return (int)ans;
    }
}