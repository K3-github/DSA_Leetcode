class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n=mat.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> b- a); 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.offer(mat[i][j]);
                if(pq.size()>k) pq.poll();
            }
        }
        return pq.peek();
    }
}