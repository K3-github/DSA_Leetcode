class Solution {
    HashSet<String> st=new HashSet<>();
    String ans="";
    private void solve(int len,int n,String curr){
        if(len==n){
            if(!st.contains(curr)){
                ans=curr;
            }
            return;
        }
        solve(len+1,n,curr+'0');
        solve(len+1,n,curr+'1');
    }
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        for(String str: nums) st.add(str);
        solve(0,n,"");
        return ans;
    }
}