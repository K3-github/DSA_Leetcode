class Solution {
    private long solve(int pos,boolean tight,int evenSum,int oddSum,int[] digits,long[][][] dp){
        int n=digits.length;
        if(pos==n){
            if(evenSum==0 || oddSum==0) return 0;
            return evenSum==oddSum ? 1 : 0;
        }
        if(!tight && dp[pos][evenSum][oddSum]!=-1) return dp[pos][evenSum][oddSum];
        int limit= tight ? digits[pos] : 9;
        long ans=0;
        for(int digit=0;digit<=limit;digit++){
            boolean newTight= tight && (digit==limit);
            if(pos%2==0){
                ans+=solve(pos+1,newTight,evenSum+digit,oddSum,digits,dp);
            }
            else{
                ans+=solve(pos+1,newTight,evenSum,oddSum+digit,digits,dp);
            }
        }
        if(!tight) dp[pos][evenSum][oddSum]=ans;
        return ans;
    }
    public long countBalanced(long low, long high) {
        String lo=String.valueOf(low-1);
        int n=lo.length();
        int[] lowDigits=new int[n];
        for(int i=0;i<n;i++){
            lowDigits[i]=lo.charAt(i)-'0';
        }
        long[][][] lowDp=new long[n][73][73];
        for(int i=0;i<n;i++){
            for(int j=0;j<73;j++){
                Arrays.fill(lowDp[i][j],-1);
            }
        }
        String hi=String.valueOf(high);
        int m=hi.length();
        int[] highDigits=new int[m];
        for(int i=0;i<m;i++){
            highDigits[i]=hi.charAt(i)-'0';
        }
        long[][][] highDp=new long[m][73][73];
        for(int i=0;i<m;i++){
            for(int j=0;j<73;j++){
                Arrays.fill(highDp[i][j],-1);
            }
        }
        return solve(0,true,0,0,highDigits,highDp)-solve(0,true,0,0,lowDigits,lowDp);
    }
}