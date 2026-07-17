class Solution {
    int[] psum;
    public Solution(int[] w) {
        int n=w.length;
        psum=new int[n];
        psum[0]=w[0];
        for(int i=1;i<n;i++){
            psum[i]=psum[i-1]+w[i];
        }
    }
    public int pickIndex() {
        int n=psum.length;
        int low=0,high=n-1;
        int randomNumber=(int)(Math.random()*psum[n-1])+1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(psum[mid]>=randomNumber){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */