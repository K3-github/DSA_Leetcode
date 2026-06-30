class Solution {
    public int minTimeToReach(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0] - b[0]); 
        pq.offer(new int[]{0,0,0});
        int[][] minTime=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(minTime[i],Integer.MAX_VALUE);
        grid[0][0]=0;
        int[] drow={0,1,0,-1};
        int[] dcol={1,0,-1,0};

        while(pq.size()>0){
            int[] tp=pq.poll();
            int currTime=tp[0],row=tp[1],col=tp[2];
            if(currTime>=minTime[row][col]) continue;
            if(row==n-1 && col==m-1) return currTime;
            minTime[row][col]=currTime;

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && minTime[nrow][ncol]==Integer.MAX_VALUE){
                    int nextTime=Math.max(grid[nrow][ncol],currTime)+1;
                    pq.offer(new int[]{nextTime,nrow,ncol});
                }
            }
        }
        return -1;
    }
}