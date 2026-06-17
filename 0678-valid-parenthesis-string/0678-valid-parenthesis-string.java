class Solution {
    private int solve(int ind,int cnt,String s,int[][] dp){
        int n=s.length();
        if(ind>=n){
            if(cnt==0) return 1;
            return 0;
        }
        if(dp[ind][cnt]!=-1) return dp[ind][cnt];

        char ch=s.charAt(ind);
        if(ch=='('){
            return dp[ind][cnt]=solve(ind+1,cnt+1,s,dp);
        }
        else if(ch==')'){
            if(cnt==0) return 0;
            return dp[ind][cnt]=solve(ind+1,cnt-1,s,dp);
        }
        else{
            int w1=solve(ind+1,cnt+1,s,dp);
            int w2=0;
            if(cnt>0){
                w2=solve(ind+1,cnt-1,s,dp);
            }
            int w3=solve(ind+1,cnt,s,dp);
            return dp[ind][cnt]=(w1==1 || w2==1 || w3==1) ? 1 : 0;
        }
    }
    public boolean checkValidString(String s) {
        int n=s.length();
        int[][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=-1;
            }
        }
        int ans=solve(0,0,s,dp);
        return ans==0 ? false : true;
    }
}