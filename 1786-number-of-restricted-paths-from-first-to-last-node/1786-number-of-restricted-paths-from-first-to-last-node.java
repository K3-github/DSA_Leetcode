class Pair{
    int dist;
    int node;

    Pair(int dist,int node){
        this.node=node;
        this.dist=dist;
    }
};
class Solution {
    int INF=Integer.MAX_VALUE;
    int mod=1000000007;
    private List<List<Pair>> createGraph(int n,int[][] edges){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0]-1,v=e[1]-1,w=e[2];
            graph.get(u).add(new Pair(w,v));
            graph.get(v).add(new Pair(w,u));
        }
        return graph;
    }
    private int solve(int node,int target,int[] distanceToLastNode,List<List<Pair>> graph,int[] dp){
        if(node==target) return 1;
        if(dp[node]!=-1) return dp[node];
        
        long ans=0;
        for(Pair p: graph.get(node)){
            int adjNode=p.node;
            if(distanceToLastNode[node]<distanceToLastNode[adjNode]){
                ans=ans+solve(adjNode,target,distanceToLastNode,graph,dp);
            }
        }
        return dp[node]=(int)(ans%mod);
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<Pair>> graph=createGraph(n,edges);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.dist - b.dist);
        int[] distanceToLastNode=new int[n];
        Arrays.fill(distanceToLastNode,INF);
        distanceToLastNode[n-1]=0;
        pq.offer(new Pair(0,n-1));

        while(pq.size()>0){
            Pair tp=pq.poll();
            int currNode=tp.node;
            int currDis=tp.dist;

            if(distanceToLastNode[currNode]<currDis) continue;

            for(Pair p: graph.get(currNode)){
                int adjNode=p.node;
                int nextDis=currDis+p.dist;
                if(nextDis<distanceToLastNode[adjNode]){
                    distanceToLastNode[adjNode]=nextDis;
                    pq.offer(new Pair(nextDis,adjNode));
                }
            }
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(n-1,0,distanceToLastNode,graph,dp);
    }
}