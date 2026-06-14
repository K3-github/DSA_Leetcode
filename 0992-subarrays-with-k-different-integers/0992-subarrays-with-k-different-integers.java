class Solution {
    private int solve(int[] nums,int k){
        int n=nums.length;
        int i=0,j=0,count=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        while(j<n){
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            while(i<=j && mp.size()>k){
                mp.put(nums[i],mp.get(nums[i])-1);
                if(mp.get(nums[i])==0) mp.remove(nums[i]);
                i++;
            }
            count+=j-i+1;
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
}