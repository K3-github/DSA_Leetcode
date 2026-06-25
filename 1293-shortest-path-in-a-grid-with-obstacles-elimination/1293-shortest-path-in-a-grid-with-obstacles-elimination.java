class Pair{
    int steps;
    int row;
    int col;
    int obs;

    Pair(int steps,int row,int col,int obs){
        this.steps=steps;
        this.row=row;
        this.col=col;
        this.obs=obs;
    }
};
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][][] vis=new int[n][m][k+1];
        q.offer(new Pair(0,0,0,k));
        vis[0][0][k]=1;

        while(q.size()>0){
            Pair p=q.poll();
            int currSteps=p.steps;
            int row=p.row;
            int col=p.col;
            int remObs=p.obs;

            if(row==n-1 && col==m-1) return currSteps;
            
            int[] drow=new int[]{0,+1,0,-1};
            int[] dcol=new int[]{+1,0,-1,0};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    if(grid[nrow][ncol]==0 && vis[nrow][ncol][remObs]==0){
                        q.offer(new Pair(1+currSteps,nrow,ncol,remObs));
                        vis[nrow][ncol][remObs]=1;
                    }
                    else if(grid[nrow][ncol]==1 && remObs>0 && vis[nrow][ncol][remObs-1]==0){
                        q.offer(new Pair(1+currSteps,nrow,ncol,remObs-1));
                        vis[nrow][ncol][remObs-1]=1;
                    }
                }
            }
        }
        return -1;
    }
}