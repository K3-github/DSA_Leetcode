class Solution {
    private boolean isValid(int row,int col,char[][] board,char ch){
        for(int i=0;i<9;i++){
            if(board[i][col]==ch) return false;
            if(board[row][i]==ch) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==ch) return false;
        }
        return true;
    }
    private boolean solve(char[][] board){
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValid(i,j,board,ch)){
                            board[i][j]=ch;
                            if(solve(board)==true) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}