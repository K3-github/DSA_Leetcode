class Solution {
    int mod=1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int curr=0;
        for(int i=0;i<n;i++){
            pq.offer(new int[]{nums[i],i});
        }
        int ind=0;
        long ans=0;
        while(!pq.isEmpty() && ind<=right-1){
            int[] tp=pq.poll();
            int currInd=tp[1];
            if(ind>=left-1){
                ans+=tp[0];
                ans=ans%mod;
            }
            if(currInd+1<n) pq.offer(new int[]{tp[0]+nums[currInd+1],currInd+1});
            ind++;
        }
        return (int)ans;
    }
}