class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int tre=n-i;
            while(st.size()>Math.max(0,k-tre) && st.peek()>nums[i]){
                st.pop();
            }
            st.push(nums[i]);
        }
        while(st.size()>k) st.pop();
        int[] ans=new int[st.size()];
        int ind=st.size()-1;
        while(st.size()>0){
            ans[ind--]=st.pop();
        }
        return ans;
    }
}