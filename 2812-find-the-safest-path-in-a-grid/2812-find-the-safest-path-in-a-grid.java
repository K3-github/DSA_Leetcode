class Solution {
    private int solve(int[][] dist){
        int n=dist.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int ans=0;
        pq.offer(new int[]{dist[0][0],0,0});
        int[][] vis=new int[n][n];

        while(pq.size()>0){
            int[] tp=pq.poll();
            int currVal=tp[0],row=tp[1],col=tp[2];

            if(vis[row][col]==1) continue;
            ans=Math.max(ans,currVal);
            if(row==n-1 && col==n-1) return currVal;
            
            vis[row][col]=1;
            int[] drow=new int[]{0,+1,0,-1};
            int[] dcol=new int[]{+1,0,-1,0};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n){
                    int newVal=Math.min(currVal,dist[nrow][ncol]);
                    pq.offer(new int[]{newVal,nrow,ncol});
                }
            }
        }
        return ans;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        Queue<int[]> q=new LinkedList<>();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    dist[i][j]=0;
                    q.offer(new int[]{0,i,j});
                }
                else dist[i][j]=Integer.MAX_VALUE;
            }
        }
        while(q.size()>0){
            int[] tp=q.poll();
            int currDis=tp[0],row=tp[1],col=tp[2];

            if(currDis>dist[row][col]) continue;

            int[] drow=new int[]{0,+1,0,-1};
            int[] dcol=new int[]{+1,0,-1,0};
            
            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && 1+currDis<dist[nrow][ncol]){
                    dist[nrow][ncol]=1+currDis;
                    q.offer(new int[]{dist[nrow][ncol],nrow,ncol});
                }
            }
        }
        return solve(dist);
    }
}