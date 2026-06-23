class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void solve(int ind,int target,int[] candidates,List<Integer> curr,int n,int k){
        if(ind>=n){
            if(target==0 && curr.size()==k) ans.add(new ArrayList<>(curr));
            return;
        }
        if(target>=candidates[ind] && curr.size()<k){
            curr.add(candidates[ind]);
            solve(ind+1,target-candidates[ind],candidates,curr,n,k);
            curr.remove(curr.size()-1);
        }
        solve(ind+1,target,candidates,curr,n,k);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates={1,2,3,4,5,6,7,8,9};
        List<Integer> curr=new ArrayList<>();
        solve(0,n,candidates,curr,9,k);
        return ans;
    }
}