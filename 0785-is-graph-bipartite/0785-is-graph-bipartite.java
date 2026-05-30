class Solution {
    private boolean bfs(int node,int[][] graph, int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.offer(node);
        color[node]=0;

        while(!q.isEmpty()){
              int curr=q.poll();

              for(int adjNode: graph[curr]){
                  if(color[adjNode]==-1){
                      color[adjNode]=1-color[curr];
                      q.offer(adjNode);
                  }
                  else if(color[adjNode]==color[curr]) return false;
              }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++) color[i]=-1;

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(bfs(i,graph,color)==false) return false;
            }
        }
        return true;
    }
}
