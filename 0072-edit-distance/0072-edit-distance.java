class Solution {
    public int minDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[] prev=new int[m+1];
        for(int j=0;j<=m;j++){
           prev[j]=j;
        }
        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            curr[0]=i;
            for(int j=1;j<=m;j++){
                char ch1=s.charAt(i-1);
                char ch2=t.charAt(j-1);
                if(ch1==ch2) curr[j]=prev[j-1];
                else{
                    int w1=1+curr[j-1];
                    int w2=1+prev[j];
                    int w3=1+prev[j-1];
                    curr[j]=Math.min(w1,Math.min(w2,w3));
                }
            }
            prev=curr;
        }
        return prev[m];
    }
}