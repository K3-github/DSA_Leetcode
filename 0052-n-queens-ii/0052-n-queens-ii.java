class Solution {
    private boolean isValid(int row,int col,char[][] board,char ch){
         int n=board.length;
         int i=row;
         while(i>=0){
            if(board[i--][col]==ch) return false;
         }
         int j=col;
        //  while(j>=0){
        //     if(board[row][j--]==ch) return false;
        //  }
         i=row;j=col;
         while(i>=0 && j>=0){
            if(board[i--][j--]==ch) return false;
         }
         i=row;j=col;
         while(i>=0 && j<n){
            if(board[i--][j++]==ch) return false;
         }
         return true;
    }
    private int solve(int row,char[][] board){
        int n=board.length;
        if(row>=n) return 1;

        int ans=0;
        for(int col=0;col<n;col++){
            if(board[row][col]=='.'){
               if(isValid(row,col,board,'Q')){
                    board[row][col]='Q';
                    ans+=solve(row+1,board);
                    board[row][col]='.';
                }
            }
        }
        return ans;
    }
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        return solve(0,board);
    }
}