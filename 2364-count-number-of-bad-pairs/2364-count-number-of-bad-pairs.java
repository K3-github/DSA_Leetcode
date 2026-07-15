class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        long count=0;
        long n=nums.length;
        long total=n*(n-1)/2;
        for(int i=0;i<n;i++){
            int req=nums[i]-i;
            if(mp.containsKey(req)){
                count+=mp.get(req);
            }
            mp.put(req,mp.getOrDefault(req,0)+1);
        }
        return total-count;
    }
}