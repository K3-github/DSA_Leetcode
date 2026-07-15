class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n=nums.size();
        TreeSet<Integer> st=new TreeSet<>();
        int ans=Integer.MAX_VALUE;
        for(int i=x;i<n;i++){
            int ele=nums.get(i);
            st.add(nums.get(i-x));
            Integer floor=st.floor(ele);
            if(floor!=null){
                ans=Math.min(ans,ele-floor);
            }
            Integer ceil=st.ceiling(ele);
            if(ceil!=null){
                ans=Math.min(ans,ceil-ele);
            }
        }
        return ans;
    }
}