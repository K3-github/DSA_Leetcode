class Solution {
    private boolean checkPalindrome(String s,int i,int j){
        while(i<j){
            char ch1=s.charAt(i);
            char ch2=s.charAt(j);
            if(ch1!=ch2) return false;
            i++;j--;
        }
        return true;
    }
    private int solve(int i,int j,String s,int[][] dp){
        if(i>j || i==j) return 0;
        if(checkPalindrome(s,i,j)==true) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxi=Integer.MAX_VALUE;
        for(int ind=i;ind<j;ind++){
            if(checkPalindrome(s,i,ind)==true){
                int cuts=1+solve(ind+1,j,s,dp);
                maxi=Math.min(maxi,cuts);
            }
        }
        return dp[i][j]=maxi;
    }
    public int minCut(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,n-1,s,dp);
    }
}