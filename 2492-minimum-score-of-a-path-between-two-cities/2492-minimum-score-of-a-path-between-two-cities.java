class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    private int solve(int node,List<List<Pair>> graph,boolean[] vis){
        if(vis[node]) return Integer.MAX_VALUE;
        
        vis[node]=true;
        int ans=Integer.MAX_VALUE;
        for(Pair p: graph.get(node)){
            int adjNode=p.first;
            int dis=p.second;
            int curr=Math.min(dis,solve(adjNode,graph,vis));
            ans=Math.min(ans,curr);
        }
        return ans;
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] rd: roads){
            int u=rd[0],v=rd[1],dist=rd[2];
            graph.get(u-1).add(new Pair(v-1,dist));
            graph.get(v-1).add(new Pair(u-1,dist));
        }
        boolean[] vis=new boolean[n];
        return solve(0,graph,vis);
    }
}