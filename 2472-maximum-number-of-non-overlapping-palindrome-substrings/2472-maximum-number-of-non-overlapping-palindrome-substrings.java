class Solution {
    private int solve(int ind,int n,int k,String s,int[] dp,boolean[][] pal){
        if(ind>=n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        
        int ans=solve(ind+1,n,k,s,dp,pal);
        for(int j=ind;j<n;j++){
            if(j-ind+1<k) continue;
            if(pal[ind][j]==true){
                ans=Math.max(ans,1+solve(j+1,n,k,s,dp,pal));
            }
        }
        return dp[ind]= ans;
    }
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || pal[i+1][j-1]==true)){
                    pal[i][j]=true;
                }
            }
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,k,s,dp,pal);
    }
}