class Solution {
    private List<List<Integer>> createGraph(int n,int[][] invocations){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: invocations){
            int u=e[0],v=e[1];
            graph.get(u).add(v);
        }
        return graph;
    }
    private void dfs(int node,boolean[] vis,List<List<Integer>> graph,boolean[] affected){
        vis[node]=true;
        affected[node]=true;

        for(Integer adjNode: graph.get(node)){
            if(!affected[adjNode]) dfs(adjNode,vis,graph,affected);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph=createGraph(n,invocations);
        boolean[] vis=new boolean[n];
        boolean[] affected=new boolean[n];
        dfs(k,vis,graph,affected);

        for(int[] e: invocations){
            int u=e[0],v=e[1];
            if(!affected[u] && affected[v]){
                Arrays.fill(affected,false);
                break;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!affected[i]) ans.add(i);
        }
        return ans;
    }
}