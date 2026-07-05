class Pair{
    int score;
    int cnt;

    Pair(int score,int cnt){
        this.score=score;
        this.cnt=cnt;
    }
};
class Solution {
    int mod=1000000007;
    private Pair solve(int row,int col,int[][] dp,int[][] ways,List<String> board){
        int n=board.size();
        if(row>=n || col>=n) return new Pair(Integer.MIN_VALUE,0);
        if(board.get(row).charAt(col)=='X') return new Pair(Integer.MIN_VALUE,0);
        if(row==n-1 && col==n-1){
            // dp[row][col]=0;
            // ways[row][col]=1;
            return new Pair(0,1);
        }
        if(dp[row][col]!=-1) return new Pair(dp[row][col],ways[row][col]);

        int ans=0;
        char ch=board.get(row).charAt(col);
        if(ch>='1' && ch<='9'){
            ans=ch-'0';
        }
        Pair down=solve(row+1,col,dp,ways,board);
        Pair digRight=solve(row+1,col+1,dp,ways,board);
        Pair right=solve(row,col+1,dp,ways,board);
        
        int mx=Math.max(down.score,Math.max(digRight.score,right.score));
        int cnt=0;
        if(mx==down.score){
            cnt=(cnt+down.cnt)%mod;
        }
        if(mx==digRight.score){
            cnt=(cnt+digRight.cnt)%mod;
        }
        if(mx==right.score){
            cnt=(cnt+right.cnt)%mod;
        }
        ways[row][col]=cnt;
        int finalVal=mx+ans;
        dp[row][col]=finalVal;
        return new Pair(finalVal,cnt);

    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int[][] ways=new int[n][n];
        solve(0,0,dp,ways,board);
        if(dp[0][0]<0) return new int[]{0,0};
        return new int[]{dp[0][0],ways[0][0]};
    }
}