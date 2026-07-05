class Solution {
    int MOD = 1000000007;
    int[][] score;
    int[][] ways;
    List<String> board;
    int n;

    private void dfs(int row,int col){

        if(row<0 || col<0 || row>=n || col>=n) return;

        if(board.get(row).charAt(col)=='X') return;

        if(score[row][col]!=Integer.MIN_VALUE) return;

        if(row==n-1 && col==n-1){
            score[row][col]=0;
            ways[row][col]=1;
            return;
        }

        dfs(row+1,col);
        dfs(row,col+1);
        dfs(row+1,col+1);

        int best=-1;
        int cnt=0;

        int[][] dir={{1,0},{0,1},{1,1}};

        for(int[] d:dir){

            int nr=row+d[0];
            int nc=col+d[1];

            if(nr>=n || nc>=n) continue;

            if(score[nr][nc]==-1 || score[nr][nc]==Integer.MIN_VALUE)
                continue;

            if(score[nr][nc]>best){
                best=score[nr][nc];
                cnt=ways[nr][nc];
            }
            else if(score[nr][nc]==best){
                cnt=(cnt+ways[nr][nc])%MOD;
            }
        }

        if(best==-1){
            score[row][col]=-1;
            ways[row][col]=0;
            return;
        }

        char ch=board.get(row).charAt(col);

        if(ch>='0' && ch<='9')
            best+=ch-'0';

        score[row][col]=best;
        ways[row][col]=cnt;
    }

    public int[] pathsWithMaxScore(List<String> board) {

        this.board=board;
        n=board.size();

        score=new int[n][n];
        ways=new int[n][n];

        for(int i=0;i<n;i++)
            Arrays.fill(score[i],Integer.MIN_VALUE);

        dfs(0,0);

        if(score[0][0]==-1)
            return new int[]{0,0};

        return new int[]{score[0][0],ways[0][0]};
    }
}