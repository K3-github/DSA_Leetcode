class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0,0});
        int[][][] minTime=new int[n][m][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(minTime[i][j],Integer.MAX_VALUE);
            }
        }
        minTime[0][0][0]=0;
        int[] drow={0,1,0,-1};
        int[] dcol={1,0,-1,0};
        while(pq.size()>0){
            int[] tp=pq.poll();
            int currTime=tp[0],row=tp[1],col=tp[2],step=tp[3];
            if(row==n-1 && col==m-1) return currTime;
            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int moveCost=(step==0)?1:2;
                    int nextTime=Math.max(currTime,moveTime[nrow][ncol])+moveCost;
                    int nextStep=1-step;
                    if(nextTime<minTime[nrow][ncol][nextStep]){
                        minTime[nrow][ncol][nextStep]=nextTime;
                        pq.offer(new int[]{nextTime,nrow,ncol,nextStep});
                    }
                }
            }
        }
        return -1;
    }
}