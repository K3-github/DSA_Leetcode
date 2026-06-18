class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] prevS=new int[n];
        for(int i=0;i<n;i++){
            prevS[i]=-1;
        }
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(int i=0;i<n;i++){
            while(st.size()>0 && heights[st.peek()]>=heights[i]){
                int width=i-prevS[st.peek()]-1;
                ans=Math.max(ans,width*heights[st.pop()]);
            }
            if(st.size()>0) prevS[i]=st.peek();
            st.push(i);
        }
        while(st.size()>0){
            int width=n-prevS[st.peek()]-1;
            ans=Math.max(ans,width*heights[st.pop()]);
        }
        return ans;
    }
}