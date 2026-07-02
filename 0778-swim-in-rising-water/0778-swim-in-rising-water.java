class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] minTime=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(minTime[i],Integer.MAX_VALUE);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0] - b[0]);
        minTime[0][0]=grid[0][0];
        pq.offer(new int[]{grid[0][0],0,0});
        
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};

        while(pq.size()>0){
            int[] tp=pq.poll();
            int currTime=tp[0],currRow=tp[1],currCol=tp[2];

            if(currRow==n-1 && currCol==n-1) return currTime;
            if(currTime>minTime[currRow][currCol]) continue;

            for(int d=0;d<4;d++){
                int nrow=currRow+drow[d];
                int ncol=currCol+dcol[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n){
                    int nextTime=Math.max(currTime,grid[nrow][ncol]);
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