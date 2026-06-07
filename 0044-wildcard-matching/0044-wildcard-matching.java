class Solution {
    private int solve(int i,int j,String s,String t,int[][] dp){
         if(i<0 && j<0) return 1;
         if(i<0 && j>=0) return 0;
         if(j<0 && i>=0){
            for(int ptr=i;ptr>=0;ptr--){
                if(s.charAt(ptr)!='*') return 0;
            }
            return 1;
         }
         if(dp[i][j]!=-1) return dp[i][j];

         char ch1=s.charAt(i);
         char ch2=t.charAt(j);
         if(ch1==ch2 || ch1=='?'){
            return dp[i][j]=solve(i-1,j-1,s,t,dp);
         }
         else if(ch1=='*'){
            int w1=solve(i-1,j,s,t,dp);
            int w2=solve(i,j-1,s,t,dp);
            return dp[i][j]=(w1==1 || w2==1 ? 1 : 0);
         }
         else return dp[i][j]=0;
         
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        int ans=solve(m-1,n-1,p,s,dp);
        return ans==1 ? true : false;
    }
}