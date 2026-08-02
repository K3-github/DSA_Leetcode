class Solution {
    private boolean isPossible(long s,int[] ms,long[] psum){
         for(int i=0;i<ms.length;i++){
             if(s+psum[i]<ms[i]) return false;
             s=Math.max(0,s-ms[i]);
         }
         return true;
    }
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long low=0,high=Long.MAX_VALUE;
        int n=monsters.length;
        long[] ba=new long[n];
        for(int[] b: boosts){
            int l=b[0],r=b[1],val=b[2];
            ba[l]+=val;
            if(r<n-1) ba[r+1]+=-val;
        }
        long[] psum=new long[n];
        psum[0]=ba[0];
        for(int i=1;i<n;i++){
           psum[i]=ba[i]+psum[i-1];
        }
        while(low<=high){
            long mid=(low+high) >> 1;
            if(isPossible(mid,monsters,psum)){
                high=mid-1;
            }
            else low=mid+1;
        }
        return low;
    }
}