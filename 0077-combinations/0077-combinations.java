class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void solve(int ind,int n,List<Integer> curr,int k){
        if(ind>n){
            if(curr.size()==k) ans.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()<k){
            curr.add(ind);
            solve(ind+1,n,curr,k);
            curr.remove(curr.size()-1);
        }
        solve(ind+1,n,curr,k);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr=new ArrayList<>();
        solve(1,n,curr,k);
        return ans;
    }
}