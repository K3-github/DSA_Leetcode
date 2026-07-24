class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        long sum=0,ans=0;
        int left=0,right=0;
        while(right<nums.length){
              mp.put(nums[right],mp.getOrDefault(nums[right],0)+1);
              sum+=nums[right];
              if(right-left+1<k){
                right++;
              }
              else if(right-left+1==k){
                if(mp.size()==k){
                    ans=Math.max(ans,sum);
                }
                sum-=nums[left];
                mp.put(nums[left],mp.get(nums[left])-1);
                if(mp.get(nums[left])==0) mp.remove(nums[left]);
                left++;right++;
              }
        }
        return ans;
    }
}