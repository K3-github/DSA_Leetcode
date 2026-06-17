class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
             int ele=nums[i];
             while(st.size()>0 && st.peek()<=ele){
                st.pop();
             }
             st.push(ele);
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++) ans[i]=-1;
        for(int i=n-1;i>=0;i--){
            int ele=nums[i];
            while(st.size()>0 && st.peek()<=ele){
                st.pop();
            }
            if(st.size()>0) ans[i]=st.peek();
            st.push(ele);
        }
        return ans;
    }
}