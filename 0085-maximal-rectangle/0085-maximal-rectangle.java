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
    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[] arr=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(matrix[i][j]=='0') arr[j]=0;
               else arr[j]+=1;
            }
            ans=Math.max(ans,largestRectangleArea(arr));
        }
        return ans;
    }
}