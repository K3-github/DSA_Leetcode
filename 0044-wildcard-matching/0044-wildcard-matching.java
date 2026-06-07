class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[] prev=new boolean[m+1];
        prev[0]=true;
        for(int j=1;j<=m;j++){
            boolean flag=true;
            for(int ptr=j;ptr>=1;ptr--){
                if(p.charAt(ptr-1)!='*'){
                    flag=false;
                    break;
                }
            }
            prev[j]=(flag==true ? true : false);
        }
        for(int i=1;i<=n;i++){
            boolean[] curr=new boolean[m+1];
            curr[0]=false;
            for(int j=1;j<=m;j++){
                char ch1=s.charAt(i-1);
                char ch2=p.charAt(j-1);
                if(ch1==ch2 || ch2=='?'){
                    curr[j]=prev[j-1];
                }
                else if(ch2=='*'){
                    boolean w1=prev[j];
                    boolean w2=curr[j-1];
                    curr[j]=w1 || w2;
                }
                else curr[j]=false;
            }
            prev=curr;
        }
        return prev[m];
    }
}