class Solution {
    private boolean isPossibleToAdd(String s,String t){
        int n=s.length();
        int m=t.length();
        if(Math.abs(n-m)!=1) return false;
        int i=0,j=0;
        int diff=0;
        while(i<n && j<m){
           char ch1=s.charAt(i);
           char ch2=t.charAt(j);
           if(ch1==ch2){
              i++;j++;
           }
           else{
              if(diff>0) return false;
              diff++;
              i++;
           }
        }
        return true;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> a.length() - b.length());
        int n=words.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        int ans=1;
        for(int i=0;i<n;i++){
            for(int prev=i-1;prev>=0;prev--){
                if(isPossibleToAdd(words[i],words[prev])){
                    dp[i]=Math.max(dp[i],1+dp[prev]);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}