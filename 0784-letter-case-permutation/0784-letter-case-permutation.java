class Solution {
    List<String> ans=new ArrayList<>();
    private void solve(int ind,int n,String curr,String s){
        if(ind>=n){
            ans.add(curr);
            return;
        }
        char ch=s.charAt(ind);
        if(ch>='0' && ch<='9'){
            solve(ind+1,n,curr+ch,s);
        }
        else{
            solve(ind+1,n,curr+Character.toLowerCase(ch),s);
            solve(ind+1,n,curr+Character.toUpperCase(ch),s);
        }
    }
    public List<String> letterCasePermutation(String s) {
        int n=s.length();
        solve(0,n,"",s);
        return ans;
    }
}