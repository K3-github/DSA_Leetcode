class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int ans=0;
        for(int n: nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        for(int key: freq.keySet()){
            if(k==0){
                if(freq.get(key)>1) ans++;
            }
            else{
                if(freq.containsKey(key+k)){
                    ans++;
                }
            }
        }
        return ans;
    }
}