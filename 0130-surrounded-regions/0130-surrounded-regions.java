class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public void solve(char[][] b) {
        int n=b.length;
        int m=b[0].length;

        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            if(b[i][0]=='O'){
                q.offer(new Pair(i,0));
                vis[i][0]=true;
            }
            if(b[i][m-1]=='O'){
                q.offer(new Pair(i,m-1));
                vis[i][m-1]=true;
            }
        }
        for(int j=1;j<m-1;j++){
            if(b[0][j]=='O'){
                q.offer(new Pair(0,j));
                vis[0][j]=true;
            }
            if(b[n-1][j]=='O'){
                q.offer(new Pair(n-1,j));
                vis[n-1][j]=true;
            }
        }

        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.first;
            int col=p.second;

            int[] drow=new int[]{-1,0,+1,0};
            int[] dcol=new int[]{0,+1,0,-1};

            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && b[nrow][ncol]=='O' && !vis[nrow][ncol]){
                    q.offer(new Pair(nrow,ncol));
                    vis[nrow][ncol]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(b[i][j]=='O' && !vis[i][j]){
                    b[i][j]='X';
                }
            }
        }
        return ;
    }
}