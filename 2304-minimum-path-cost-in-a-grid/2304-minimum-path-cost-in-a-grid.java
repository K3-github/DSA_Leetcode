class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[][] minCost=new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(minCost[i],Integer.MAX_VALUE);
        for(int col=0;col<m;col++){
            pq.offer(new int[]{grid[0][col],0,col});
            minCost[0][col]=grid[0][col];
        }

        while(pq.size()>0){
            int[] tp=pq.poll();
            int currCost=tp[0],currRow=tp[1],currCol=tp[2];

            if(currRow==n-1 && currCol==m-1) return currCost;
            if(currCost>minCost[currRow][currCol]) continue;

            for(int j=0;j<m;j++){
                if(currRow+1<n){
                    int nextCost=currCost+grid[currRow+1][j]+moveCost[grid[currRow][currCol]][j];
                    if(nextCost<minCost[currRow+1][j]){
                        minCost[currRow+1][j]=nextCost;
                        pq.offer(new int[]{minCost[currRow+1][j],currRow+1,j});
                    }
                }
            }
        }
        return -1; 
    }
}