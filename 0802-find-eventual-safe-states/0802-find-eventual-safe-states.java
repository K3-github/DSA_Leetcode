class Solution {
    private boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] pathVis,boolean[] check){
           vis[node]=true;
           pathVis[node]=true;
           check[node]=false;

           for(int adjNode: graph[node]){
               if(!vis[adjNode]){
                  if(dfs(adjNode,graph,vis,pathVis,check)==true) return true;
               }
               else if(pathVis[adjNode]==true) return true;
           }

           check[node]=true;
           pathVis[node]=false;
           return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int n=graph.length;
        boolean[] vis=new boolean[n];
        boolean[] pathVis=new boolean[n];
        boolean[] check=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis,pathVis,check);
            }
        }
        for(int i=0;i<n;i++){
            if(check[i]==true) ans.add(i);
        }
        return ans;
    }
}