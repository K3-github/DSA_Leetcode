class Solution {
    private int solve(int pos,int tight,int cntEven,int cntOdd,int rem,int k,char[] digits,int started,int[][][][][][] dp){
        if(pos==digits.length) return (cntEven==cntOdd && rem==0) ? 1 : 0;
        if(dp[pos][tight][cntEven][cntOdd][rem][started]!=-1) return dp[pos][tight][cntEven][cntOdd][rem][started];

        int limit= tight==1 ? digits[pos]-'0' : 9;
        int ans=0;

        for(int digit=0;digit<=limit;digit++){
            int newTight= (tight==1 && (digit==limit)) ? 1 : 0;
            if(started==1){
                if(digit%2==0){
                    ans+=solve(pos+1,newTight,cntEven+1,cntOdd,(rem*10+digit)%k,k,digits,1,dp);
                }
                else{
                    ans+=solve(pos+1,newTight,cntEven,cntOdd+1,(rem*10+digit)%k,k,digits,1,dp);
                }
            }
            else{
                if(digit%2==1){
                    ans+=solve(pos+1,newTight,cntEven,cntOdd+1,(rem*10+digit)%k,k,digits,1,dp);
                }
                else if(digit!=0){
                    ans+=solve(pos+1,newTight,cntEven+1,cntOdd,(rem*10+digit)%k,k,digits,1,dp);
                }
                else{
                    ans+=solve(pos+1,newTight,cntEven,cntOdd,(rem*10+digit)%k,k,digits,0,dp);
                }
            }
        }
        return dp[pos][tight][cntEven][cntOdd][rem][started]=ans;
    }
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        char[] d1=String.valueOf(low-1).toCharArray();
        char[] d2=String.valueOf(high).toCharArray();
        int[][][][][][] dp1=new int[d1.length][2][11][11][k][2];
        for(int i=0;i<d1.length;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<11;l++){
                    for(int m=0;m<11;m++){
                        for(int n=0;n<k;n++){
                            Arrays.fill(dp1[i][j][l][m][n],-1);
                        }
                    }
                }
            }
        }
        int[][][][][][] dp2=new int[d2.length][2][11][11][k][2];
        for(int i=0;i<d2.length;i++){
            for(int j=0;j<2;j++){
                for(int l=0;l<11;l++){
                    for(int m=0;m<11;m++){
                        for(int n=0;n<k;n++){
                            Arrays.fill(dp2[i][j][l][m][n],-1);
                        }
                    }
                }
            }
        }
        return solve(0,1,0,0,0,k,d2,0,dp2)-solve(0,1,0,0,0,k,d1,0,dp1);
    }
}