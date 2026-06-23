class Solution {
    private int solve(int ind,int cnt,int n,String s,int[][] dp,boolean[][] pal){
        if(cnt==3){
            return ind==n ? 1 : 0;
        }
        if(ind>=n){
            return 0;
        }
        if(dp[ind][cnt]!=-1) return dp[ind][cnt];
        int ans=0;
        for(int j=ind;j<n;j++){
            if(pal[ind][j]==true){
                int res=solve(j+1,cnt+1,n,s,dp,pal);
                if(res==1) ans=1;
            }
        }
        return dp[ind][cnt]=ans;
    }
    public boolean checkPartitioning(String s) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || pal[i+1][j-1])){
                    pal[i][j]=true;
                }
            }
        }
        int[][] dp=new int[n][4];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans=solve(0,0,n,s,dp,pal);
        return ans==0 ? false : true;
    }
}