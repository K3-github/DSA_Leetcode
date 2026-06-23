class Solution {
    List<List<String>> ans = new ArrayList<>();
    private boolean isPalindrome(String s,int i,int j){
        while(i<j){
            char ch1=s.charAt(i++);
            char ch2=s.charAt(j--);
            if(ch1!=ch2) return false;
        }
        return true;
    }
    private void solve(int ind,int n,String s,List<String> curr){
        if(ind>=n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int j=ind;j<n;j++){
            if(isPalindrome(s,ind,j)==true){
                String str=s.substring(ind,j+1);
                curr.add(str);
                solve(j+1,n,s,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<String> curr=new ArrayList<>();
        int n=s.length();
        solve(0,n,s,curr);
        return ans;
    }
}