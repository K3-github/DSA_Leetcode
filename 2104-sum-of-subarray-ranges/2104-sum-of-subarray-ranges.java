class Solution {
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        int[] nextG=new int[n];
        int[] nextS=new int[n];
        int[] prevG=new int[n];
        int[] prevS=new int[n];
        for(int i=0;i<n;i++){
            prevG[i]=-1;prevS[i]=-1;
            nextG[i]=n;nextS[i]=n;
        }

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()>0 && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.size()>0) prevG[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.size()>0) nextG[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=0;i<n;i++){
            while(st.size()>0 && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.size()>0) prevS[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.size()>0) nextS[i]=st.peek();
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            int noOfTimesMin=(nextS[i]-i)*(i-prevS[i]);
            int noOfTimesMax=(nextG[i]-i)*(i-prevG[i]);
            ans+=(noOfTimesMax-noOfTimesMin)*(long)nums[i];
        }
        return ans;
    }
}