class Solution {
    public int minTimeToReach(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        int[][] minTime=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(minTime[i],Integer.MAX_VALUE);
        minTime[0][0]=0;

        while(pq.size()>0){
            int[] tp=pq.poll();
            int currTime=tp[0],row=tp[1],col=tp[2];

            if(row==n-1 && col==m-1) return currTime;

            int[] drow={0,1,0,-1};
            int[] dcol={1,0,-1,0};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int nextTime=Math.max(grid[nrow][ncol],currTime)+1;
                    if(nextTime<minTime[nrow][ncol]){
                        minTime[nrow][ncol]=nextTime;
                        pq.offer(new int[]{nextTime,nrow,ncol});
                    }
                }
            }
        }
        return -1;
    }
}