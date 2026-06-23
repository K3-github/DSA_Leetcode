class Solution {
    String[] map={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans=new ArrayList<>();
    private void solve(int ind,int n,String curr,String digits){
        if(ind>=n){
            ans.add(curr);
            return;
        }
        int mapInd=digits.charAt(ind)-'0';
        for(char ch: map[mapInd-2].toCharArray()){
            solve(ind+1,n,curr+ch,digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        solve(0,n,"",digits);
        return ans;
    }
}