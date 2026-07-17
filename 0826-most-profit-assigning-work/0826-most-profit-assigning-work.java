class Solution {
    private int bsearch(int[][] v,int x){
        int low=0,high=v.length-1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(v[mid][0]<=x){
                low=mid+1;
            }
            else high=mid-1;
        }
        return high;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=difficulty.length;
        int[][] v=new int[n][2];
        for(int i=0;i<n;i++){
            v[i]=new int[]{difficulty[i],profit[i]};
        }
        Arrays.sort(v,(a,b)-> a[0] - b[0]);
        int[] leftMx=new int[n];
        leftMx[0]=v[0][1];
        for(int i=1;i<n;i++){
            leftMx[i]=Math.max(leftMx[i-1],v[i][1]);
        }
        int ans=0;
        for(int i=0;i<worker.length;i++){
            int cap=worker[i];
            int ind=bsearch(v,cap);
            if(ind>=0) ans+=leftMx[ind];
        }
        return ans;
    }
}
