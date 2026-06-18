class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nextS=new int[n];
        int[] prevS=new int[n];
        for(int i=0;i<n;i++){
            prevS[i]=-1;nextS[i]=n;
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.size()>0) prevS[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.size()>0) nextS[i]=st.peek();
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            int width=nextS[i]-prevS[i]-1;
            ans=Math.max(ans,width*heights[i]);
        }
        return ans;
    }
}