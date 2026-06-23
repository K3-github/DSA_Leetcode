class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void solve(int ind,int n,List<Integer> curr, int[] nums){
        if(ind>=n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[ind]);
        solve(ind+1,n,curr,nums);
        curr.remove(curr.size()-1);
        while(ind+1<n && nums[ind]==nums[ind+1]) ind++;
        solve(ind+1,n,curr,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr=new ArrayList<>();
        int n=nums.length;
        solve(0,n,curr,nums);
        return ans;
    }
}