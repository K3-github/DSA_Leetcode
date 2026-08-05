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
    private void dfs(int node,List<List<Integer>> graph,boolean[] affected){
        affected[node]=true;

        for(Integer adjNode: graph.get(node)){
            if(!affected[adjNode]) dfs(adjNode,graph,affected);
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph=createGraph(n,invocations);
        boolean[] affected=new boolean[n];
        dfs(k,graph,affected);
        
        for(int[] e: invocations){
            int u=e[0],v=e[1];
            if(!affected[u] && affected[v]){
                List<Integer> all=new ArrayList<>();
                for(int i=0;i<n;i++){
                    all.add(i);
                }
                return all;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!affected[i]) ans.add(i);
        }
        return ans;
    }
}