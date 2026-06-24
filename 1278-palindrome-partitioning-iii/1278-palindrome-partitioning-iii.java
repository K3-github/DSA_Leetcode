class Solution {
    private int cal(String s,int i,int j){
        int count=0;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) count++;
        }
        return count;
    }
    private int solve(int ind,int cnt,int k,String s,int[][] dp){
        int n=s.length();
        if(cnt==k) return (ind==n ? 0 : 10000);
        if(ind>=n) return 10000;
        if(dp[ind][cnt]!=-1) return dp[ind][cnt];

        int ans=100000;
        for(int j=ind;j<n;j++){
            int total=cal(s,ind,j)+solve(j+1,cnt+1,k,s,dp);
            ans=Math.min(ans,total);
        }
        return dp[ind][cnt]=ans;
    }
    public int palindromePartition(String s, int k) {
        int n=s.length();
        int[][] dp=new int[n][k+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return solve(0,0,k,s,dp);
    }
}