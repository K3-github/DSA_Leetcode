class Solution {
    int[] digits;
    int len;
    private int solve(int pos,boolean tight,int countOne,int[][] dp){
        if(pos==len) return countOne;
        if(!tight && dp[pos][countOne]!=-1) return dp[pos][countOne];

        int limit=tight ? digits[pos] : 9;
        int ans=0;
        
        for(int digit=0;digit<=limit;digit++){
            boolean newTight= tight && (digit==limit);
            if(digit==1){
                ans+=solve(pos+1,newTight,countOne+1,dp);
            }
            else{
                ans+=solve(pos+1,newTight,countOne,dp);
            }
        }
        if(!tight) dp[pos][countOne]=ans;
        return ans;
    }
    public int countDigitOne(int n) {
        String str=String.valueOf(n);
        len=str.length();
        digits=new int[len];
        for(int i=0;i<len;i++){
            digits[i]=str.charAt(i)-'0';
        }
        int[][] dp=new int[len][11];
        for(int i=0;i<len;i++){
           Arrays.fill(dp[i],-1);
        }
        return solve(0,true,0,dp);
    }
}
