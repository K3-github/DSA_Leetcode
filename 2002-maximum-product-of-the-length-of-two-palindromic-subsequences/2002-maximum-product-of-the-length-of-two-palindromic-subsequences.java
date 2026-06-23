class Solution {
    int ans=0;
    private boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
    private void solve(int ind,String s,String s1,String s2){
        if(ind==s.length()){
            if(isPalindrome(s1) && isPalindrome(s2)){
                ans=Math.max(ans,s1.length()*s2.length());
            }
            return;
        }
        char ch=s.charAt(ind);
        solve(ind+1,s,s1+ch,s2);
        solve(ind+1,s,s1,s2+ch);
        solve(ind+1,s,s1,s2);
    }
    public int maxProduct(String s){
        solve(0,s,"","");
        return ans;
    }
}