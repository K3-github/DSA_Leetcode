class Pair{
    int unsafe;
    int row;
    int col;

    Pair(int unsafe,int row,int col){
        this.unsafe=unsafe;
        this.row=row;
        this.col=col;
    }
};
class Solution {
    public boolean findSafeWalk(List<List<Integer>> mat, int health) {
         int n=mat.size();
         int m=mat.get(0).size();
         int[][] grid=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]=mat.get(i).get(j);
            }
         }
         int[][] unsafes=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                unsafes[i][j]=1000000000;
            }
         }
         PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.unsafe - b.unsafe);
         if(grid[0][0]==1){
            pq.offer(new Pair(1,0,0));
            unsafes[0][0]=1;
         }
         else{
            pq.offer(new Pair(0,0,0));
            unsafes[0][0]=0;
         }

         while(pq.size()>0){
            Pair p=pq.poll();
            int unsafe=p.unsafe;
            int row=p.row;
            int col=p.col;

            if(row==n-1 && col==m-1) return unsafe<health;
            if(unsafe>unsafes[row][col]) continue;

            int[] drow=new int[]{0,+1,0,-1};
            int[] dcol=new int[]{+1,0,-1,0};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    if(grid[nrow][ncol]==1){
                        if(1+unsafe<unsafes[nrow][ncol]){
                            pq.offer(new Pair(1+unsafe,nrow,ncol));
                            unsafes[nrow][ncol]=1+unsafe;
                        }
                    }
                    else{
                        if(unsafe<unsafes[nrow][ncol]){
                            pq.offer(new Pair(unsafe,nrow,ncol));
                            unsafes[nrow][ncol]=unsafe;
                        }
                    }
                }
            }
         }
         return false;
    }
}