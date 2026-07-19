class Solution {
    int[] drow=new int[]{0,+1,0,-1};
    int[] dcol=new int[]{+1,0,-1,0};
    private void solve(int row,int col,int[][] mat){
        int n=mat.length;
        if(row<0 || row>=n || col<0 || col>=n || mat[row][col]==1) return;

        mat[row][col]=1;
        
        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            solve(nrow,ncol,mat);
        }
    }
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int[][] mat=new int[3*n][3*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char ch=grid[i].charAt(j);
                if(ch=='/'){
                  mat[i*3][j*3+2]=1;
                  mat[i*3+1][j*3+1]=1;
                  mat[i*3+2][j*3]=1;
                }
                else if(ch=='\\'){
                    mat[i*3][j*3]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3+2]=1;
                }
            }
        }
        int regions=0;
        for(int i=0;i<3*n;i++){
            for(int j=0;j<3*n;j++){
                if(mat[i][j]==0){
                    solve(i,j,mat);
                    regions++;
                }
            }
        }
        return regions;
    }
}