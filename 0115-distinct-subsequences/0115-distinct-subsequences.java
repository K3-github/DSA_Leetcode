class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] prev=new int[m+1];
        for(int i=0;i<=n;i++) prev[0]=1;
        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            curr[0]=1;
            for(int j=1;j<=m;j++){
                char ch1=s.charAt(i-1);
                char ch2=t.charAt(j-1);
                if(ch1==ch2){
                    int w1=prev[j-1];
                    int w2=prev[j];
                    curr[j]= w1+w2;
                }
                else{
                    curr[j]=prev[j];
                }
            }
            prev=curr;
        }
        return prev[m];
    }
}