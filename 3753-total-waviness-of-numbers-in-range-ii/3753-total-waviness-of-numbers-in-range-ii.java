class Solution {
    private long solve(int pos,boolean tight,int ld,int sld,int started,int w,char[] digits,long[][][][][] dp){
        int len=digits.length;
        if(pos==len) return w;
        if(!tight && dp[pos][ld][sld][started][w]!=-1) return dp[pos][ld][sld][started][w];

        int limit = tight ? digits[pos] - '0' : 9;
        long ans=0;
        for(int digit=0;digit<=limit;digit++){
            boolean newTight = tight && (digit==limit);
            int newW=w;
            if(started==0 && digit==0){
                ans+=solve(pos+1,newTight,ld,sld,0,newW,digits,dp);
            }
            else{
                if(sld!=10 && ld!=10 && sld<ld && ld>digit) newW=w+1;
                if(sld!=10 && ld!=10 && sld>ld && ld<digit) newW=w+1;
                ans+=solve(pos+1,newTight,digit,ld,1,newW,digits,dp);
            }
        }
        if(!tight) return dp[pos][ld][sld][started][w]=ans;
        return ans;
    }
    public long totalWaviness(long num1, long num2) {
        char[] arr1=String.valueOf(num1-1).toCharArray();
        char[] arr2=String.valueOf(num2).toCharArray();
        int n=arr1.length,m=arr2.length;
        long[][][][][] dp1=new long[n][11][11][2][17];
        for(int i=0;i<n;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<11;k++){
                    for(int r=0;r<2;r++){
                        Arrays.fill(dp1[i][j][k][r],-1);
                    }
                }
            }
        }
        long[][][][][] dp2=new long[m][11][11][2][17];
        for(int i=0;i<m;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<11;k++){
                    for(int r=0;r<2;r++){
                        Arrays.fill(dp2[i][j][k][r],-1);
                    }
                }
            }
        }
        return solve(0,true,10,10,0,0,arr2,dp2)-solve(0,true,10,10,0,0,arr1,dp1);
    }
}