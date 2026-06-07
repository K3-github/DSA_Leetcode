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

    int m=s.length();
    int n=p.length();

    boolean[][] dp=new boolean[m+1][n+1];

    dp[0][0]=true;

    for(int j=1;j<=n;j++){

        boolean flag=true;

        for(int ptr=j;ptr>=1;ptr--){

            if(p.charAt(ptr-1)!='*'){
                flag=false;
                break;
            }
        }

        dp[0][j]=flag;
    }

    for(int i=1;i<=m;i++){
        dp[i][0]=false;
    }

    for(int i=1;i<=m;i++){

        for(int j=1;j<=n;j++){

            char ch1=s.charAt(i-1);
            char ch2=p.charAt(j-1);

            if(ch1==ch2 || ch2=='?'){

                dp[i][j]=dp[i-1][j-1];
            }
            else if(ch2=='*'){

                boolean w1=dp[i-1][j];
                boolean w2=dp[i][j-1];

                dp[i][j]=w1 || w2;
            }
            else{
                dp[i][j]=false;
            }
        }
    }

    return dp[m][n];
}
}