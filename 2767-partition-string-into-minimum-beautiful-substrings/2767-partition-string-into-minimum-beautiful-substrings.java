class Solution {
    private boolean isPowerOf5(String s, int i, int j) {
        int n=0;
        for(int k=i;k<=j;k++) {
            n=(n<<1)+(s.charAt(k)-'0');
        }
        return n>0 && 1220703125%n==0;
      }  
    private int solve(int ind,int n,String s,int[] dp){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int ans=Integer.MAX_VALUE;
        for(int j=ind;j<n;j++){
            if(s.charAt(ind)=='0') continue;
            if(isPowerOf5(s,ind,j)==true){
                int par=solve(j+1,n,s,dp);
                if(par!=Integer.MAX_VALUE) ans=Math.min(ans,1+par);
            }
        }
        return dp[ind]=ans;
    }
    public int minimumBeautifulSubstrings(String s) {
        int n=s.length();
        if(s.charAt(0)=='0') return -1;
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=-1;
        int ans=solve(0,n,s,dp);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}