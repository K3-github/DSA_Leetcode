class Solution {
    private boolean dfs(int node,int dest,List<List<Integer>> graph,boolean[] vis){
        if(node==dest) return true;

        vis[node]=true;
        for(int adjNode: graph.get(node)){
            if(vis[adjNode]==false){
                if(dfs(adjNode,dest,graph,vis)==true) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean vis[] = new boolean[n];
        return dfs(source,destination,graph,vis);
    }
}