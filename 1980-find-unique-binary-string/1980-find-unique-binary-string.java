class Solution {
    HashSet<String> st=new HashSet<>();
    private String solve(int len,int n,String curr){
        if(len==n){
            if(!st.contains(curr)){
                return curr;
            }
            return "";
        }
        String left=solve(len+1,n,curr+'0');
        if(!left.equals("")) return left;
        String right=solve(len+1,n,curr+'1');
        if(!right.equals("")) return right;
        return "";
    }
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        for(String str: nums) st.add(str);
        return solve(0,n,"");
    }
}