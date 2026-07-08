class Solution {
    public int distinctEchoSubstrings(String text) {
        int n=text.length();
        int[][] dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(text.charAt(i)==text.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }
            }
        }
        HashSet<String> st=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int len=1;i+2*len<=n;len++){
                if(dp[i][i+len]>=len){
                    st.add(text.substring(i,i+2*len));
                }
            }
        }
        return st.size();
    }
}