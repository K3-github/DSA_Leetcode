class Solution {
    HashSet<String> st=new HashSet<>();
    List<String> ans=new ArrayList<>();
    private void solve(int ind,int n,String s){
        if(ind>=n) return;

        for(int j=ind;j<n;j++){
            String seg=s.substring(ind,j+1);
            if(!st.contains(seg)){
                st.add(seg);
                ans.add(seg);
                solve(j+1,n,s);
                break;
            }
        }
        return;
    }
    public List<String> partitionString(String s) {
        int n=s.length();
        solve(0,n,s);
        return ans;
    }
}