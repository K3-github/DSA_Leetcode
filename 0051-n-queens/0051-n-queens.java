class Solution {
    List<List<String>> ans=new ArrayList<>();
    private boolean isValid(int row,int col,char[][] board,char ch){
         int n=board.length;
         int i=row;
         while(i>=0){
            if(board[i--][col]==ch) return false;
         }
         int j=col;
         i=row;
         while(i>=0 && j>=0){
            if(board[i--][j--]==ch) return false;
         }
         i=row;j=col;
         while(i>=0 && j<n){
            if(board[i--][j++]==ch) return false;
         }
         return true;
    }
    private void solve(int row,char[][] board){
        int n=board.length;
        if(row>=n){
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int col=0;col<n;col++){
            if(board[row][col]=='.'){
               if(isValid(row,col,board,'Q')){
                    board[row][col]='Q';
                    solve(row+1,board);
                    board[row][col]='.';
                }
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(0,board);
        return ans;
    }
}