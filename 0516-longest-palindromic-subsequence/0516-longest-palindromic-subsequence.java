class Solution {
    public int longestPalindromeSubseq(String t1) {
        StringBuilder sb=new StringBuilder(t1);
        String t2=sb.reverse().toString();
        int n=t1.length();
        int m=t2.length();
        if(n==0 || m==0) return 0;
        int[] prev=new int[m+1];

        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            for(int j=1;j<=m;j++){
                char ch1=t1.charAt(i-1);
                char ch2=t2.charAt(j-1);
                if(ch1==ch2){
                    curr[j]=1+prev[j-1];
                }
                else{
                    int w1=prev[j];
                    int w2=curr[j-1];
                    curr[j]=Math.max(w1,w2);
                } 
            }
            prev=curr;
        }
        return prev[m];
    }
}