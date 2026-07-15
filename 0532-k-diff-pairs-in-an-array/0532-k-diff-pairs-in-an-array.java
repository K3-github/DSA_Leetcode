class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> mp=new HashMap<>();
        HashSet<String> st=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                if(k==0) st.add(nums[i]+","+nums[i-1]);
            }
            int diff=nums[i]-k;
            if(mp.containsKey(diff)) st.add(nums[i]+","+diff);
            mp.put(nums[i],1);
        }
        return st.size();
    }
}