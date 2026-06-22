class Solution {
    List<String> ans=new ArrayList<>();
    private void solve(int open,int close,String str){
        if(open<0) return;
        if(open==0 && close==0){
            ans.add(str);
            return;
        }
        solve(open-1,close,str+'(');
        if(open==0 || open<close){
            solve(open,close-1,str+')');
        }
    }
    public List<String> generateParenthesis(int n) {
        solve(n,n,"");
        return ans;
    }
}