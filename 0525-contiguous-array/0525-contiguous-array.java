class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int curr=0;
        int ans=0;
        mp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) curr--;
            else curr++;

            if(mp.containsKey(curr)){
                ans=Math.max(ans,i-mp.get(curr));
            }
            else mp.put(curr,i);
        }
        return ans;
    }
}