class Solution {
    private int solve(int pos,boolean tight,String[] digits,char[] num,int[] dp){
        int len=num.length;
        if(pos==len) return 1;
        if(!tight && dp[pos]!=-1) return dp[pos];

        int limit= tight ? num[pos]-'0' : 9;
        int ans=0;
        for(String digit: digits){
           int digit_num=Integer.parseInt(digit);
           if(digit_num>limit) break; 
           boolean newTight= tight && (digit_num==limit);
           ans+=solve(pos+1,newTight,digits,num,dp);
        }
        if(!tight) return dp[pos]=ans;
        return ans;
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] num=String.valueOf(n).toCharArray();
        int m=digits.length;
        int len=num.length;
        int cnt=0;
        for(int i=1;i<len;i++){
           cnt+=Math.pow(m,i);
        }
        int[] dp=new int[len];
        Arrays.fill(dp,-1);
        return cnt+solve(0,true,digits,num,dp);
    }
}