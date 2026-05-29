class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q=new LinkedList<>();
        
        int n=mat.length;
        int m=mat[0].length;
        
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{0,i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] tp=q.poll();
            int dis=tp[0],row=tp[1],col=tp[2];
            
            ans[row][col]=dis;
            int[] drow=new int[]{-1,0,+1,0};
            int[] dcol=new int[]{0,+1,0,-1};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1){
                    q.offer(new int[]{dis+1,nrow,ncol});
                    mat[nrow][ncol]=0;
                }
            }
        }
        return ans;
    }
}