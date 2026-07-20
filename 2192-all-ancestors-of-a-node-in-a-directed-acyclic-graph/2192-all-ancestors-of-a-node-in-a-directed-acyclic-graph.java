class Solution {
    private void dfs(int node,int start,List<List<Integer>> graph,List<Integer> ancestors,boolean[] vis){
        if(vis[node]) return;
        vis[node]=true;
        if(node!=start) ancestors.add(node);
        for(Integer adjNode: graph.get(node)){
            if(!vis[adjNode])dfs(adjNode,start,graph,ancestors,vis);
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
            dfs(i,i,graph,ancestors,vis);
            Collections.sort(ancestors);
            ans.add(new ArrayList<>(ancestors));
        }
        return ans;
    }
}