class Solution {
    int mod=1000000007;
    private String subtractOne(String s) {
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > '0') {
                arr[i]--;
                break;
            }
            arr[i] = '9';
        }
        int start = 0;
        while (start < arr.length - 1 && arr[start] == '0') {
            start++;
        }
        return new String(arr, start, arr.length - start);
    }
    private int solve(int pos,boolean tight,int currSum,int mn,int mx,int len,String digits,int[][] dp){
        if(currSum>mx) return 0;
        if(pos==len){
           if(currSum>=mn && currSum<=mx) return 1;
           return 0;
        }
        if(!tight && dp[pos][currSum]!=-1) return dp[pos][currSum];

        int limit= tight ? digits.charAt(pos)-'0' : 9;
        long ans=0;

        for(int digit=0;digit<=limit;digit++){
            boolean newTight= tight && (digit == limit);
            ans+=solve(pos+1,newTight,currSum+digit,mn,mx,len,digits,dp);
            ans=ans%mod;
        }
        if(!tight) dp[pos][currSum]=(int)ans;
        return (int)ans;
    }
    public int count(String num1, String num2, int min_sum, int max_sum) {
        num1=subtractOne(num1);
        int[][] dp1=new int[num2.length()][23*9+1];
        for(int i=0;i<num2.length();i++){
            Arrays.fill(dp1[i],-1);
        }
        int[][] dp2=new int[num1.length()][23*9+1];
        for(int i=0;i<num1.length();i++){
            Arrays.fill(dp2[i],-1);
        }
        return (solve(0,true,0,min_sum,max_sum,num2.length(),num2,dp1)-solve(0,true,0,min_sum,max_sum,num1.length(),num1,dp2)+mod)%mod;
    }
}