class Solution {
    private boolean isMatch(String q,String p){
        int n=q.length(),m=p.length();
        int i=0,j=0;
        while(i<n && j<m){
            char ch1=q.charAt(i);
            char ch2=p.charAt(j);
            if(ch1==ch2){
                i++;j++;
            }
            else{
                if(ch1>='A' && ch1<='Z') return false;
                i++;
            }
        }
        while(i<n){
            char ch1=q.charAt(i);
            if(ch1>='A' && ch1<='Z') return false;
            i++;
        }
        return (j==m);
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<>();
        for(String q: queries){
            ans.add(isMatch(q,pattern));
        }
        return ans;
    }
}