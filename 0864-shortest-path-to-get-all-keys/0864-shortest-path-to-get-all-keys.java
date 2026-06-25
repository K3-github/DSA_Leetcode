class Pair{
        int row;
        int col;
        int mask;
        int steps;
        
        Pair(int row,int col,int mask,int steps){
            this.row=row;
            this.col=col;
            this.mask=mask;
            this.steps=steps;
        }
};
class Solution {
    private boolean isPossible(int r,int c,char[][] grid,int mask){
        int n=grid.length;
        int m=grid[0].length;
        if(r<0 || r>=n || c<0 || c>=m) return false;
        char ch=grid[r][c];
        if(ch=='#') return false;
        if(ch>='A' && ch<='F'){
            if((mask & (1<<(ch-'A'))) == 0)
                return false;
        }
        return true;
    }
    public int shortestPathAllKeys(String[] grid){
        int n=grid.length;
        int m=grid[0].length();
        char[][] mat=new char[n][m];
        Queue<Pair> q=new LinkedList<>();
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=grid[i].charAt(j);
                mat[i][j]=ch;
                if(ch=='@'){
                    q.offer(new Pair(i,j,0,0));
                }
                if(ch>='a' && ch<='f'){
                    total++;
                }
            }
        }

        boolean[][][] visited=new boolean[n][m][1<<6];
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int mask=curr.mask;

            if(mask==(1<<total)-1)
                return curr.steps;

            if(visited[r][c][mask])
                continue;

            visited[r][c][mask]=true;
            int[] dr={1,-1,0,0};
            int[] dc={0,0,1,-1};
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(isPossible(nr,nc,mat,mask)){
                    int newMask=mask;
                    char ch=mat[nr][nc];
                    if(ch>='a' && ch<='f'){
                        newMask |= (1<<(ch-'a'));
                    }
                    if(!visited[nr][nc][newMask]){
                        q.offer(
                            new Pair(nr,nc,newMask,curr.steps+1)
                        );
                    }
                }
            }
        }
        return -1;
    }
}