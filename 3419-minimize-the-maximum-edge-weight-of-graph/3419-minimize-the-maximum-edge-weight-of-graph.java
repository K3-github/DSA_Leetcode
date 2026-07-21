class Solution {
    int reachableNodes;
    private void solve(int node,List<List<Integer>> graph,boolean[] vis){
        if(vis[node]) return;
        vis[node]=true;
        reachableNodes++;
        for(Integer adjNode: graph.get(node)){
            if(!vis[adjNode]) solve(adjNode,graph,vis);
        }
    }
    private boolean isPossible(int n,int[][] edges,int mw){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1],w=e[2];
            if(w<=mw){
                graph.get(v).add(u);
            }
        }
        boolean[] vis=new boolean[n];
        reachableNodes=0;
        solve(0,graph,vis);
        return n==reachableNodes;
    }
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        int low=0,high=1000000;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(isPossible(n,edges,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low>1000000 ? -1 : low;
    }
}