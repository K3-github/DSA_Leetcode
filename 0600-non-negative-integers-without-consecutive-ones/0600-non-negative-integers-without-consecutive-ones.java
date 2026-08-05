class Solution {
    int[] digits=new int[32];
    private int solve(int pos,boolean tight,int prevBit,int[][] dp){
        if(pos==32) return 1;
        if(!tight && dp[pos][prevBit]!=-1) return dp[pos][prevBit];

        int limit= tight ? digits[pos] : 1;
        int ans=0;

        for(int digit=0;digit<=limit;digit++){
            boolean newTight= tight && (digit==limit);
            if(prevBit==1 && digit==1) continue;
            ans+=solve(pos+1,newTight,digit,dp);
        }
        if(!tight) return dp[pos][prevBit]=ans;
        return ans;
    }
    public int findIntegers(int n) {
        for(int i=31;i>=0;i--){
            digits[31-i] = 1 & (n>>i);
        }
        int[][] dp=new int[32][2];
        for(int i=0;i<32;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,true,0,dp);
    }
}