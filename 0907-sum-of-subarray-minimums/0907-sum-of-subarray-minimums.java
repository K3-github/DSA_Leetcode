class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[] prev=new int[n];
        int[] next=new int[n];
        for(int i=0;i<n;i++){
            prev[i]=-1;
            next[i]=n;
        }
        for(int i=0;i<n;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.size()>0) prev[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()>0) next[i]=st.peek();
            st.push(i);
        }
        long ans=0;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            int left=i-prev[i];
            int right=next[i]-i;
            long num=((left%mod)*(right%mod)%mod);
            ans=(ans+((num%mod)*(arr[i]%mod))%mod)%mod;
        }
        return (int)ans;
    }
}