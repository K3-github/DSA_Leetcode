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
    private String convertBaseB(String s, int base) {
        if (s.equals("0")) return "0";
        StringBuilder ans = new StringBuilder();
        while (!s.equals("0")) {
            StringBuilder quotient = new StringBuilder();
            int rem = 0;
            for (int i = 0; i < s.length(); i++) {
                int cur = rem * 10 + (s.charAt(i) - '0');
                quotient.append(cur / base);
                rem = cur % base;
            }
            ans.append((char)('0' + rem));
            int idx = 0;
            while (idx < quotient.length() - 1 && quotient.charAt(idx) == '0') {
                idx++;
            }
            s = quotient.substring(idx);
        }
        return ans.reverse().toString();
    }
    private int solve(int pos,int tight,int prevD,String digits,int base,int started,int[][][][] dp){
        if(pos==digits.length()) return 1;
        if(dp[pos][tight][prevD][started]!=-1) return dp[pos][tight][prevD][started];

        int limit= tight == 1 ? digits.charAt(pos)-'0' : base-1;
        long ans=0;

        for(int digit=0;digit<=limit;digit++){
            int newTight= (tight ==1 && (digit==limit)) ? 1 : 0;
            if(started==0 && digit==0){
               ans+=solve(pos+1,newTight,prevD,digits,base,0,dp);
            }
            else if(prevD==base){
                ans+=solve(pos+1,newTight,digit,digits,base,1,dp);
            }
            else if(digit>=prevD){
               ans+=solve(pos+1,newTight,digit,digits,base,1,dp);
            }
        }
        return dp[pos][tight][prevD][started]=(int)(ans%mod);
    }
    public int countNumbers(String l, String r, int b) {
        String low=convertBaseB(subtractOne(l),b);
        String high=convertBaseB(r,b);
        
        int ll=low.length();
        int[][][][] lowDp=new int[ll][2][b+1][2];
        for(int i=0;i<ll;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<b+1;k++){
                    Arrays.fill(lowDp[i][j][k],-1);
                }
            }
        }
        int hl=high.length();
        int[][][][] highDp=new int[hl][2][b+1][2];
        for(int i=0;i<hl;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<b+1;k++){
                    Arrays.fill(highDp[i][j][k],-1);
                }
            }
        }
        return (solve(0,1,b,high,b,0,highDp)-solve(0,1,b,low,b,0,lowDp)+mod)%mod;
    }
}


