class Solution {
    private boolean solve(int row,int col,int ind,char[][] board,String word){
        int n=board.length;
        int m=board[0].length;
        if(ind==word.length()) return true;
        if(row<0 || row>=n || col<0 || col>=m || board[row][col]=='#' || word.charAt(ind)!=board[row][col]) return false;

        char ch=board[row][col];
        board[row][col]='#';
        
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};

        for(int d=0;d<4;d++){
            int nrow=row+drow[d];
            int ncol=col+dcol[d];
            if(solve(nrow,ncol,ind+1,board,word)==true) return true;
        }
        board[row][col]=ch;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j]){
                   if(solve(i,j,0,board,word)==true) return true;
                }
            }
        }
        return false;
    }
}