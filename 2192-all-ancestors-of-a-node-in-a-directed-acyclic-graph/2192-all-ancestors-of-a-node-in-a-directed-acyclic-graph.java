class Solution {
    private void dfs(int node,List<List<Integer>> graph,List<Integer> ancestors,boolean[] vis){
        if(vis[node]) return;
        vis[node]=true;
        ancestors.add(node);
        for(Integer adjNode: graph.get(node)){
            if(!vis[adjNode])dfs(adjNode,graph,ancestors,vis);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1];
            graph.get(v).add(u);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> ancestors=new ArrayList<>();
            boolean[] vis=new boolean[n];
            dfs(i,graph,ancestors,vis);
            ancestors.remove(0);
            Collections.sort(ancestors);
            ans.add(new ArrayList<>(ancestors));
        }
        return ans;
    }
}