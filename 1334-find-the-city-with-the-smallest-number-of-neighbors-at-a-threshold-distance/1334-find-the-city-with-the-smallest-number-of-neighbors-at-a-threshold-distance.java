class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        int INF=1000000007;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=INF;
                if(i==j) dist[i][j]=0;
            }
        }
        for(int[] e: edges){
            dist[e[0]][e[1]]=e[2];
            dist[e[1]][e[0]]=e[2];
        }

        for(int via=0;via<n;via++){

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]!=INF && dist[via][j]!=INF){
                        dist[i][j]=Math.min(dist[i][j],
                                dist[i][via]+dist[via][j]);
                    }
                }
            }

        }
        int ans=0;
        int mn=INF;
        for(int i=0;i<n;i++){
            int neigh=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    neigh++;
                }
            }
            if(neigh<=mn){
                mn=neigh;
                ans=i;
            }
        }
        return ans;
    }
}