class Solution {
    private int solve(int pos,boolean tight,int pro,int currSum,int started,int sum,int[] digits,int[][][][] dp){
        int len=digits.length;
        if(currSum>sum) return 0;
        if(pos==len){
            if(started==0) return 0;
            if(currSum==sum) return pro%sum==0 ? 1 : 0;
            return 0;
        }
        if(!tight && dp[pos][pro][currSum][started]!=-1) return dp[pos][pro][currSum][started];
        int limit= tight ? digits[pos] : 9;
        int ans=0;
        for(int digit=0;digit<=limit;digit++){
            boolean newTight= tight && (digit==limit);
            if(started==0 && digit==0){
                ans+=solve(pos+1,newTight,pro,currSum+digit,0,sum,digits,dp);
            }
            else{
                ans+=solve(pos+1,newTight,pro*digit%sum,currSum+digit,1,sum,digits,dp);
            }
        }
        if(!tight) dp[pos][pro][currSum][started]=ans;
        return ans;
    }
    public int beautifulNumbers(int l, int r) {
        String low=String.valueOf(l-1);
        int n=low.length();
        int[] lowDigits=new int[n];
        for(int i=0;i<n;i++){
            lowDigits[i]=low.charAt(i)-'0';
        }

        String high=String.valueOf(r);
        int m=high.length();
        int[] highDigits=new int[m];
        for(int i=0;i<m;i++){
            highDigits[i]=high.charAt(i)-'0';
        }

        int cnt=0;
        for(int sum=1;sum<=9*m;sum++){
            int[][][][] highDp=new int[m][sum+1][sum+1][2];
            for(int i=0;i<m;i++){
                for(int j=0;j<sum+1;j++){
                    for(int k=0;k<sum+1;k++){
                        Arrays.fill(highDp[i][j][k],-1);
                    }
                }
            }
            cnt+=solve(0,true,1,0,0,sum,highDigits,highDp);
        }
        for(int sum=1;sum<=9*n;sum++){
            int[][][][] lowDp=new int[n][sum+1][sum+1][2];
            for(int i=0;i<n;i++){
                for(int j=0;j<sum+1;j++){
                    for(int k=0;k<sum+1;k++){
                        Arrays.fill(lowDp[i][j][k],-1);
                    }
                }
            }
            cnt-=solve(0,true,1,0,0,sum,lowDigits,lowDp);
        }
        return cnt;
    }
}
