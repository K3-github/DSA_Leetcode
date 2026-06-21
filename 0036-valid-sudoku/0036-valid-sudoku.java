class Solution {
    HashMap<Integer,HashSet<Character>> row=new HashMap<>();
    HashMap<Integer,HashSet<Character>> col=new HashMap<>();
    HashMap<Integer,HashSet<Character>> box=new HashMap<>();
    private boolean isValid(int i,int j,char ch){
         int boxId=3*(i/3)+(j/3);
         if(row.get(i).contains(ch)) return false;
         if(col.get(j).contains(ch)) return false;
         if(box.get(boxId).contains(ch)) return false;
         return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<9;i++){
            row.put(i,new HashSet<>());
            col.put(i,new HashSet<>());
            box.put(i,new HashSet<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.') continue;
                char ch=board[i][j];
                int boxId=3*(i/3)+(j/3);
                if(isValid(i,j,ch)==false) return false;
                row.get(i).add(ch);
                col.get(j).add(ch);
                box.get(boxId).add(ch);
            }
        }
        return true;
    }
}