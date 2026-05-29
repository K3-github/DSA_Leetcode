class Pair{
    int first;
    int second;
    
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(sr,sc));
        int intColor=image[sr][sc];
        image[sr][sc]=newColor;
        int n=image.length;
        int m=image[0].length;
        
        boolean[][] vis=new boolean[n][m];
        vis[sr][sc]=true;
        
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.first;
            int col=p.second;
            
            int[] drow=new int[]{-1,0,+1,0};
            int[] dcol=new int[]{0,+1,0,-1};
            
            for(int d=0;d<4;d++){
                int nrow=row+drow[d];
                int ncol=col+dcol[d];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m 
                     && image[nrow][ncol]==intColor && !vis[nrow][ncol]){
                    image[nrow][ncol]=newColor;
                    q.offer(new Pair(nrow,ncol));
                    vis[nrow][ncol]=true;
                }
            }
        }
        return image;
    }
}