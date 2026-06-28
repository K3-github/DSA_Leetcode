class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<int[]> q=new LinkedList<>();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dist[i],100000000);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{0,i,j});
                    dist[i][j]=0;
                }
            }
        }
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};

        while(q.size()>0){
            int[] tp=q.poll();
            int currDis=tp[0],row=tp[1],col=tp[2];

            if(dist[row][col]<currDis) continue;

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && 1+currDis<dist[nrow][ncol]){
                    dist[nrow][ncol]=1+currDis;
                    q.offer(new int[]{dist[nrow][ncol],nrow,ncol});
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dist[i][j]);
            }
        }
        return ans==100000000 || ans==0 ? -1 : ans;
    }
}