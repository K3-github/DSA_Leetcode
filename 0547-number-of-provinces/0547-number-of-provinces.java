class Solution {
    private void dfs(int node, List<List<Integer>> graph, boolean[] vis){
        if(vis[node]) return;

        vis[node]=true;
        for(int adjNode: graph.get(node)){
            dfs(adjNode,graph,vis);
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        int count=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,graph,vis);
            }
        }
        return count;
    }
}