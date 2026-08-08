class Solution {
    int mod=1000000007;
    private String subtractByOne(String s){
        char[] arr=s.toCharArray();
        int len=arr.length;
        for(int i=len-1;i>=0;i--){
           if(arr[i]=='0') arr[i]='9';
           else{
               arr[i]--;
               break;
           }
        }
        int left=0;
        while(left<len-1 && arr[left]=='0'){
            left++;
        }
        return new String(arr).substring(left);
    }
    private int solve(int pos,boolean tight,int prevDigit,int started,char[] digits,int[][][] dp){
        if(pos==digits.length) return started == 1 ? 1 : 0;
        if(!tight && dp[pos][prevDigit][started]!=-1) return dp[pos][prevDigit][started];
        
        int limit= tight ? digits[pos]-'0' : 9;
        long ans=0;

        for(int digit=0;digit<=limit;digit++){
            boolean newTight = tight && (digit==digits[pos]-'0');
            
            if(prevDigit==10){
                if(digit==0){
                    ans+=solve(pos+1,newTight,prevDigit,0,digits,dp);
                }
                else{
                    ans+=solve(pos+1,newTight,digit,1,digits,dp);
                }
            }
            else{
                if(Math.abs(prevDigit-digit)==1){
                    ans+=solve(pos+1,newTight,digit,1,digits,dp);
                }
            }
            ans=ans%mod;
        }
        if(!tight) return dp[pos][prevDigit][started]=(int)ans;
        return (int)ans;
    }
    public int countSteppingNumbers(String low, String high) {
        char[] d1=subtractByOne(low).toCharArray();
        char[] d2=high.toCharArray();
        int[][][] dp1=new int[d1.length][11][2];
        for(int i=0;i<d1.length;i++){
            for(int j=0;j<11;j++){
                Arrays.fill(dp1[i][j],-1);
            }
        }
        int[][][] dp2=new int[d2.length][11][2];
        for(int i=0;i<d2.length;i++){
            for(int j=0;j<11;j++){
                Arrays.fill(dp2[i][j],-1);
            }
        }
        return (solve(0,true,10,0,d2,dp2)-solve(0,true,10,0,d1,dp1)+mod)%mod;
    }
}
