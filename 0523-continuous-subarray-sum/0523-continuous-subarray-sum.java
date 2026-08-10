class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int n=nums.length;
        int curr=0;
        mp.put(0,-1);
        for(int i=0;i<n;i++){
           curr+=nums[i];
           if(mp.containsKey(curr%k)){
              int ind=mp.get(curr%k);
              if(i-ind>=2) return true;
           }
           else mp.put(curr%k,i);
        }
        return false;
    }
}