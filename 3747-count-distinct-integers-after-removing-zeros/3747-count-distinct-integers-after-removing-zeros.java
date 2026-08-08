class Solution {
    private long solve(int pos,boolean tight,int started,char[] digits,long[][] dp){
       if(pos==digits.length) return started==1 ? 1 : 0;
       if(!tight && dp[pos][started]!=-1) return dp[pos][started];

       int limit=tight ? digits[pos]-'0' : 9;
       long ans=0;

       for(int digit=0;digit<=limit;digit++){
          boolean newTight= tight && (digit==digits[pos]-'0');
          if(started==0){
             if(digit==0){
                ans+=solve(pos+1,newTight,0,digits,dp);
             }
             else{
                ans+=solve(pos+1,newTight,1,digits,dp);
             }
          }
          else{
            if(digit!=0) ans+=solve(pos+1,newTight,1,digits,dp);
          }
       }
       if(!tight) return dp[pos][started]=ans;
       return ans;
    }
    public long countDistinct(long n) {
        char[] digits=String.valueOf(n).toCharArray();
        long[][] dp=new long[digits.length][2];
        for(int i=0;i<digits.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,true,0,digits,dp);
    }
}