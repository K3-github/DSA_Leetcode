class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b - a);
        for(int n: nums) pq.offer(n);
        long ans=0;
        while(pq.size()>0 && k>0){
              int tp=pq.poll();
              ans+=tp;
              pq.offer((tp+2)/3);
              k--;
        }
        return ans;
    }
}