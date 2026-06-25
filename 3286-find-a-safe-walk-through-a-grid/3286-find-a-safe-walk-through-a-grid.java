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
    public boolean findSafeWalk(List<List<Integer>> mat, int health){
        int n=mat.size();
        int m=mat.get(0).size();
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.unsafe-b.unsafe);
        pq.offer(new Pair(mat.get(0).get(0),0,0));
        dist[0][0]=mat.get(0).get(0);

        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int unsafe=p.unsafe;
            int row=p.row;
            int col=p.col;

            if(row==n-1 && col==m-1) return unsafe < health;
            if(unsafe>dist[row][col])continue;

            for(int i=0;i<4;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int newUnsafe =unsafe + mat.get(nr).get(nc);
                    if(newUnsafe < dist[nr][nc]){
                        dist[nr][nc]=newUnsafe;
                        pq.offer(new Pair(newUnsafe,nr,nc));
                    }
                }
            }
        }
        return false;
    }
}