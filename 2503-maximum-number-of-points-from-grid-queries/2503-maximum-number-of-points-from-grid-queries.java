class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n=grid.length;
        int m=grid[0].length;
        int qsize=queries.length;
        int[] answer=new int[qsize];
        int[][] qs=new int[qsize][2];
        for(int i=0;i<qsize;i++){
            qs[i][0]=queries[i];
            qs[i][1]=i;
        }
        Arrays.sort(qs,(a,b)-> a[0] - b[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0] - b[0]);
        boolean[][] vis=new boolean[n][m];
        pq.offer(new int[]{grid[0][0],0,0});
        vis[0][0]=true;
        int count=0;
        for(int i=0;i<qsize;i++){
            int limit=qs[i][0];
            while(pq.size()>0 && pq.peek()[0]<limit){
                int[] tp=pq.poll();
                int row=tp[1],col=tp[2];

                count++;
                
                int[] drow=new int[]{0,+1,0,-1};
                int[] dcol=new int[]{+1,0,-1,0};

                for(int d=0;d<4;d++){
                    int nrow=row+drow[d];
                    int ncol=col+dcol[d];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==false){
                        pq.offer(new int[]{grid[nrow][ncol],nrow,ncol});
                        vis[nrow][ncol]=true;
                    }
                }
            }
            answer[qs[i][1]]=count;
        }
        return answer;
    }
}