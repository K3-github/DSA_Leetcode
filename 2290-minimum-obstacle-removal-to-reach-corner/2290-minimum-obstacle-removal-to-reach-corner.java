class Pair{
    int obs;
    int row;
    int col;

    Pair(int obs,int row,int col){
        this.obs=obs;
        this.row=row;
        this.col=col;
    }
};
class Solution {
    public int minimumObstacles(int[][] grid) {
         int n=grid.length;
         int m=grid[0].length;
         int[][] obstacles=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                obstacles[i][j]=1000000000;
            }
         }
         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.obs - b.obs);
         pq.offer(new Pair(0,0,0));
         obstacles[0][0]=0;

         while(pq.size()>0){
            Pair p=pq.poll();
            int obs=p.obs;
            int row=p.row;
            int col=p.col;

            if(row==n-1 && col==m-1) return obs;
            if(obs>obstacles[row][col]) continue;

            int[] drow=new int[]{0,+1,0,-1};
            int[] dcol=new int[]{+1,0,-1,0};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    if(grid[row][col]==1){
                        if(1+obs<obstacles[nrow][ncol]){
                            pq.offer(new Pair(1+obs,nrow,ncol));
                            obstacles[nrow][ncol]=1+obs;
                        }
                    }
                    else{
                        if(obs<obstacles[nrow][ncol]){
                            pq.offer(new Pair(obs,nrow,ncol));
                            obstacles[nrow][ncol]=obs;
                        }
                    }
                }
            }
         }
         return -1;
    }
}