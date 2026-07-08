class Solution {
    HashSet<String> st=new HashSet<>();
    List<String> ans=new ArrayList<>();
    private void solve(int ind,List<String> curr,String s){
        if(ind==s.length()){
            String str=String.join(" ",curr);
            ans.add(str);
            return;
        }
        for(int j=ind;j<s.length();j++){
            String sub=s.substring(ind,j+1);
            if(st.contains(sub)){
                curr.add(sub);
                solve(j+1,curr,s);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String str: wordDict){
            st.add(str);
        }
        List<String> curr=new ArrayList<>();
        solve(0,curr,s);
        return ans;
    }
}