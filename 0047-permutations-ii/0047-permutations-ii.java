class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    HashSet<List<Integer>> st=new HashSet<>();
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return;
    }
    private void solve(int ind,int n,int[] nums){
        if(ind==n){
            List<Integer> li=new ArrayList<>();
            for(int i=0;i<n;i++) li.add(nums[i]);
            if(!st.contains(li)){
                ans.add(li);
                st.add(li);
            }
            return;
        }
        for(int ptr=ind;ptr<n;ptr++){
             swap(nums,ind,ptr);
             solve(ind+1,n,nums);
             swap(nums,ind,ptr);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        solve(0,n,nums);
        return ans;
    }
}