class Solution {
    int[] digits;
    int len;
    private int solve(int pos,boolean tight,int mask,int[][] dp){
        if(pos==len) return mask==0 ? 0 : 1;
        if(!tight && dp[pos][mask]!=-1) return dp[pos][mask];

        int limit=tight ? digits[pos] : 9;
        int ans=0;

        for(int digit=0;digit<=limit;digit++){
            boolean newTight=tight && (digit==limit);
            if(mask==0 && digit==0){
                ans+=solve(pos+1,newTight,mask,dp);
            }
            else{
                if((mask & (1<<digit))!=0) continue;

                int newMask=mask | (1<<digit);
                ans+=solve(pos+1,newTight,newMask,dp);
            }
        }
        if(!tight) return dp[pos][mask]=ans;
        return ans;
    }
    public int numDupDigitsAtMostN(int n) {
        String str=String.valueOf(n);
        len=str.length();
        digits=new int[len];
        for(int i=0;i<len;i++){
            digits[i]=str.charAt(i)-'0';
        }
        int[][] dp=new int[len][1<<10];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
        }
        return n-solve(0,true,0,dp);
    }
}