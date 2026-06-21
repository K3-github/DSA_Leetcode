class Solution {
    HashMap<Integer,HashSet<Character>> row=new HashMap<>();
    HashMap<Integer,HashSet<Character>> col=new HashMap<>();
    HashMap<Integer,HashSet<Character>> box=new HashMap<>();
    private boolean solve(char[][] board){
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.'){
                    for(char d='1';d<='9';d++){
                        int boxId=3*(i/3)+(j/3); 
                        if(row.get(i).contains(d) || col.get(j).contains(d) ||box.get(boxId).contains(d)) continue;

                        board[i][j]=d;
                        row.get(i).add(board[i][j]);
                        col.get(j).add(board[i][j]);
                        box.get(boxId).add(board[i][j]);
                        if(solve(board)==true) return true;
                        else{
                            board[i][j]='.';
                            row.get(i).remove(d);
                            col.get(j).remove(d);
                            box.get(boxId).remove(d);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<9;i++){
            row.put(i,new HashSet<>());
            col.put(i,new HashSet<>());
            box.put(i,new HashSet<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]!='.'){
                    row.get(i).add(board[i][j]);
                    col.get(j).add(board[i][j]);
                    int boxId=3*(i/3)+(j/3);
                    box.get(boxId).add(board[i][j]);
                }
            }
        }
        solve(board);
    }
}