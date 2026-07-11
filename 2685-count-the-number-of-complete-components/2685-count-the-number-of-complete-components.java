class Solution {
    int nn=0,ne=0;
    int[] ind;
    private void solve(int node,List<List<Integer>> graph,boolean[] vis){
        vis[node]=true;
        nn++;
        ne+=ind[node];
        for(int adjNode: graph.get(node)){
            if(vis[adjNode]==false) solve(adjNode,graph,vis);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] vis=new boolean[n];
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        ind=new int[n];
        for(int[] e: edges){
            int u=e[0],v=e[1];
            ind[u]++;ind[v]++;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                nn=0;ne=0;
                solve(i,g,vis);
                int me=nn*(nn-1)/2;
                if((ne/2)==me) count++;
            }
        }
        return count;
    }
}
