class Solution {
    private long countPairs(int L,int R,int k){
        long ans=0;
        long upto=Math.min(L,k);
        long full=Math.max(0,Math.min(upto,k+1-R));
        ans+=full*R;
        long start=full+1;
        if(start<=upto){
            long cnt=upto-start+1;
            ans+=(long)(k+1)*cnt-(start+upto)*cnt/2;
        }
        return ans;
     }
    public long minMaxSubarraySum(int[] nums, int k) {
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
            long minCnt=countPairs(i-prevS[i],nextS[i]-i,k);
            long maxCnt=countPairs(i-prevG[i],nextG[i]-i,k);
            ans+=minCnt*(long)nums[i];
            ans+=maxCnt*(long)nums[i];
        }
        return ans;
    }
}