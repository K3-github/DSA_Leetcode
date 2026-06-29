class Solution {
    int mxRow,mxCol;
    private void solve(int row,int col,int[][] land){
        int n=land.length;
        int m=land[0].length;
        if(row<0 || row>=n || col<0 || col>=m || land[row][col]==0) return;

        land[row][col]=0;
        mxRow=Math.max(mxRow,row);
        mxCol=Math.max(mxCol,col);
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};

        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            solve(nrow,ncol,land);
        }
    }
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans=new ArrayList<>();
        int n=land.length;
        int m=land[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mxRow=i;mxCol=j;
                if(land[i][j]==1){
                    solve(i,j,land);
                    ans.add(new int[]{i,j,mxRow,mxCol});
                }
            }
        }
        int size=ans.size();
        int[][] res=new int[size][4];
        for(int i=0;i<size;i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}