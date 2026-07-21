class Pair{
    int dist;
    int node;

    Pair(int dist,int node){
        this.dist=dist;
        this.node=node;
    }
};
class Solution {
    int INF=Integer.MAX_VALUE;
    private List<List<Integer>> createGraph(int n,int[][] edges){
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        return g;
    }
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n=patience.length;
        List<List<Integer>> graph=createGraph(n,edges);
        Queue<Pair> q=new LinkedList<>();
        int[] dist=new int[n];
        Arrays.fill(dist,INF);
        q.offer(new Pair(0,0));
        dist[0]=0;

        while(q.size()>0){
            Pair tp=q.poll();
            int currNode=tp.node;
            int currDis=tp.dist;

            if(currDis>dist[currNode]) continue;

            for(Integer adjNode: graph.get(currNode)){
                if(currDis+1<dist[adjNode]){
                    dist[adjNode]=currDis+1;
                    q.offer(new Pair(currDis+1,adjNode));
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(patience[i]!=0){
                int rt = 2 * dist[i];
                int lastSent = ((rt - 1) / patience[i]) * patience[i];
                ans = Math.max(ans, lastSent + rt + 1);
            }
        }
        return ans;
    }
}