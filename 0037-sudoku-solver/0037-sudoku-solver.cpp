class Solution {
public:
    bool isValid(char ch,vector<vector<char>>& board,int row,int col){
        for(int i=0;i<9;i++){
            if(board[row][i]==ch) return false;
            if(board[i][col]==ch) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==ch) return false;
        }
        return true;
    }
    bool solve(vector<vector<char>>& board){
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(c,board,i,j)){
                            board[i][j]=c;
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
    void solveSudoku(vector<vector<char>>& board) {
        // unordered_map<int,unordered_set<int>> row;
        // unordered_map<int,unordered_set<int>> col;
        // unordered_map<int,unordered_set<int>> box;
        solve(board);
    }
};