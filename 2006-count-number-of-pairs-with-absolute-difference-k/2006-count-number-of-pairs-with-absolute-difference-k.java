class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
           int diff=nums[i]-k;
           if(mp.containsKey(diff)){
              count+=mp.get(diff);
           }
           mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}