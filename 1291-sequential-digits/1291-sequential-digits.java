class Solution {
    List<Integer> ans=new ArrayList<>();
    private void solve(int ind,int low,int high){
        if(ind>9) return;
        long res=0;
        for(int j=ind;j<=9;j++){
            res=res*10+j;
            if(res>=low && res<=high){
                ans.add((int)res);
            }
        }
        solve(ind+1,low,high);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        solve(1,low,high);
        Collections.sort(ans);
        return ans;
    }
}