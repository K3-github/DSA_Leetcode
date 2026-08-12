class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> f=new HashMap<>();
        int n=nums.length;
        int i=0,j=0;
        int ans=0;
        while(j<n){
            f.put(nums[j],f.getOrDefault(nums[j],0)+1);
            while(i<j && f.get(nums[j])>k){
                f.put(nums[i],f.get(nums[i])-1);
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}