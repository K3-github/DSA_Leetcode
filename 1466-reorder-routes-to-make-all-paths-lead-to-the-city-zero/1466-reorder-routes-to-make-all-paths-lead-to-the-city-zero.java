class Pair{
    int node;
    int cost;

    Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
};
class Solution {
    int ans=0;
    private void dfs(int node,List<List<Pair>> graph,boolean[] vis){
        vis[node]=true;
        
        for(Pair p: graph.get(node)){
            int adjNode=p.node;
            int cost=p.cost;
            if(!vis[adjNode]){
                ans+=cost;
                dfs(adjNode,graph,vis);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: connections){
            int u=e[0],v=e[1];
            graph.get(u).add(new Pair(v,1));
            graph.get(v).add(new Pair(u,0));
        }
        boolean[] vis=new boolean[n];
        dfs(0,graph,vis);
        return ans;
    }
}