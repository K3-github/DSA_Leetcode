class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)-> a[0] - b[0]);
        q.offer(new int[]{0,0,0});
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        while(!q.isEmpty()){
            int[] tp=q.poll();
            int effort=tp[0],row=tp[1],col=tp[2];

            if(row==n-1 && col==m-1) return effort;

            int[] drow=new int[]{-1,0,+1,0};
            int[] dcol=new int[]{0,+1,0,-1};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int edgeWeight =
                        Math.abs(heights[row][col] - heights[nrow][ncol]);

                    int newEffort = Math.max(effort, edgeWeight);

                    if(newEffort<dist[nrow][ncol]){
                        q.offer(new int[]{newEffort,nrow,ncol});
                        dist[nrow][ncol]=newEffort;
                    }
                }
            }
        }
        return -1;
    }
}