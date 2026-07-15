class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n=nums.size();
        TreeSet<Integer> st=new TreeSet<>();
        int ans=Integer.MAX_VALUE;
        for(int i=x;i<n;i++){
            st.add(nums.get(i-x));
            Integer floor=st.floor(nums.get(i));
            if(floor!=null){
                ans=Math.min(ans,nums.get(i)-floor);
            }
            Integer ceil=st.ceiling(nums.get(i));
            if(ceil!=null){
                ans=Math.min(ans,ceil-nums.get(i));
            }
        }
        return ans;
    }
}