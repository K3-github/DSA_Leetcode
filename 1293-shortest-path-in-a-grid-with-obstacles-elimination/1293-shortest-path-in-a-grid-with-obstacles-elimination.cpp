class Solution {
public:
    int shortestPath(vector<vector<int>>& grid, int k) {
        int n=grid.size();
        int m=grid[0].size();
        queue<pair<int,pair<int,int>>> q;
        q.push({k,{0,0}});
        vector<vector<vector<int>>> vis(n,vector<vector<int>>(m,vector<int>(k+1,0)));
        vis[0][0][k]=1;
        int steps=0;
        while(q.size()>0){
            int size=q.size();
            while(size--){
                int r=q.front().first;
                int x=q.front().second.first;
                int y=q.front().second.second;
                q.pop();

                if(x==n-1 and y==m-1) return steps;
                int dx[]={-1,0,+1,0};
                int dy[]={0,+1,0,-1};
                for(int i=0;i<4;i++){
                    int nrow=x+dx[i];
                    int ncol=y+dy[i];
                    if(nrow>=0 and nrow<n and ncol>=0 and ncol<m){
                        if(grid[nrow][ncol]==0 and vis[nrow][ncol][r]==0){
                            q.push({r,{nrow,ncol}});
                            vis[nrow][ncol][r]=1;
                        }
                        else if(grid[nrow][ncol]==1 and r>0 and vis[nrow][ncol][r-1]==0){
                            q.push({r-1,{nrow,ncol}});
                            vis[nrow][ncol][r-1]=1;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
};