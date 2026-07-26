class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()==0 || nums[st.peek()]>nums[i]){
                st.push(i);
            }
        }
        int ans=0;
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]<=nums[i]){
                ans=Math.max(ans,i-st.pop());
            }
        }
        return ans;
    }
}
