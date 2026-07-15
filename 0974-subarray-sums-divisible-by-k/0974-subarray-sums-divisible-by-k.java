class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int curr=0,count=0;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            int req=(k+curr%k)%k;
            if(mp.containsKey(req)){
                count+=mp.get(req);
            }
            mp.put(req,mp.getOrDefault(req,0)+1);
        }
        return count;
    }
}