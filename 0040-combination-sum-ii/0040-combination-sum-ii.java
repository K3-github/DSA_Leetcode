class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void solve(int ind,int target,int[] candidates,List<Integer> curr,int n){
        if(ind>=n){
            if(target==0) ans.add(new ArrayList<>(curr));
            return;
        }
        
        if(target>=candidates[ind]){
            curr.add(candidates[ind]);
            solve(ind+1,target-candidates[ind],candidates,curr,n);
            curr.remove(curr.size()-1);
        }
        while(ind+1<n && (candidates[ind]==candidates[ind+1])) ind++;
        solve(ind+1,target,candidates,curr,n);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n=candidates.length;
        List<Integer> curr=new ArrayList<>();
        solve(0,target,candidates,curr,n);
        return ans;
    }
}