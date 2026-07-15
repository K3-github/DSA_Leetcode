class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int num: nums) freq.put(num,freq.getOrDefault(num,0)+1);
        int count=0;
        for(int key: freq.keySet()){
            int val=freq.get(key);
            count+=val*(val-1)/2;
        }
        return count;
    }
}