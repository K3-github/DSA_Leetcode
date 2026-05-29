class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{0,i,j});
                }
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            int[] tp=q.poll();
            int time=tp[0],row=tp[1],col=tp[2];
            
            ans=Math.max(ans,time);

            int[] dx=new int[]{-1,0,+1,0};
            int[] dy=new int[]{0,+1,0,-1};

            for(int d=0;d<4;d++){
                int nrow=row+dx[d];
                int ncol=col+dy[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                    q.offer(new int[]{time+1,nrow,ncol});
                    grid[nrow][ncol]=2;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return ans;
    }
}