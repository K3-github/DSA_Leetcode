class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int next=nums[0];
        int i=0;
        List<Integer> ans=new ArrayList<>();
        while(i<n){
            if(next!=nums[i]){
                ans.add(next);
            }
            else i++;
            next++;
        }
        return ans;
    }
}