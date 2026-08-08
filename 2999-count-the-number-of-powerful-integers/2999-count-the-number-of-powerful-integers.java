class Solution {
    private long solve(int pos,boolean tight,String suff,int limit,int index,char[] digits,int ind,int started,long[][][] dp){
       if(pos==digits.length) return 1;
       if(!tight && dp[pos][ind][started]!=-1) return dp[pos][ind][started];

       int currLimit= tight ? digits[pos]-'0' : limit;
       long ans=0;
       
       if(pos>=index){
           int digit=suff.charAt(ind)-'0';
           if (digit>currLimit) return 0;
           boolean newTight = tight && (digit == currLimit);
           ans+=solve(pos+1,newTight,suff,limit,index,digits,ind+1,started,dp);
       }
       else{
           int maxDigit = Math.min(currLimit, limit);
           for(int digit=0;digit<=maxDigit;digit++){
              boolean newTight= tight && (digit==currLimit);
              if(started==0){
                  ans+=solve(pos+1,newTight,suff,limit,index,digits,ind,0,dp);
              }
              else{
                 if(digit==0) continue;
                 ans+=solve(pos+1,newTight,suff,limit,index,digits,ind,1,dp);
              }
              
           }
       }
       if(!tight) return dp[pos][ind][started]=ans;
       return ans;
    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        char[] high = String.valueOf(finish).toCharArray();
        char[] low = String.valueOf(start - 1).toCharArray();

        int highIndex = high.length - s.length();
        int lowIndex = low.length - s.length();

        long highCount = 0;
        long lowCount = 0;

        long[][][] lowDp=new long[low.length][s.length()][2];
        for(int i=0;i<low.length;i++){
            for(int j=0;j<s.length();j++){
                Arrays.fill(lowDp[i][j],-1);
            }
        }
        long[][][] highDp=new long[high.length][s.length()][2];
        for(int i=0;i<high.length;i++){
            for(int j=0;j<s.length();j++){
                Arrays.fill(highDp[i][j],-1);
            }
        }

        if(highIndex >= 0) {
            highCount = solve(0, true, s, limit,highIndex, high, 0,0,highDp);
        }
        if(lowIndex >= 0) {
            lowCount = solve(0, true, s, limit,lowIndex, low, 0,0,lowDp);
        }
        return highCount - lowCount;
    }
}