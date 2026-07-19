class Solution {
    HashSet<Integer> st=new HashSet<>();
    private int solve(int node,List<List<Integer>> graph,boolean[] vis){
        vis[node]=true;
        int ans=0;
        for(Integer adjNode: graph.get(node)){
            if(!vis[adjNode] && !st.contains(adjNode)){
               ans+=solve(adjNode,graph,vis);
            }
        }
        return 1+ans;
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int node: restricted) st.add(node);
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        return solve(0,graph,vis);
    }
}