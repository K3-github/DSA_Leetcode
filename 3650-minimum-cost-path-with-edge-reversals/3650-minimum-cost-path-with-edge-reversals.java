class Pair{
    int cost;
    int node;

    Pair(int cost,int node){
        this.cost=cost;
        this.node=node;
    }
};
class Solution {
    int INF=Integer.MAX_VALUE;
    private List<List<Pair>> createGraph(int n, int[][] edges){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1],w=e[2];
            graph.get(u).add(new Pair(w,v));
            graph.get(v).add(new Pair(2*w,u));
        }
        return graph;
    }
    public int minCost(int n, int[][] edges) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int[] minCost=new int[n];
        Arrays.fill(minCost,INF);
        minCost[0]=0;
        pq.offer(new Pair(0,0));
        List<List<Pair>> graph=createGraph(n,edges);
        while(pq.size()>0){
            Pair p=pq.poll();
            int currNode=p.node;
            int currCost=p.cost;

            if(currNode==n-1) return currCost; 
            if(currCost>minCost[currNode]) continue;

            for(Pair pr: graph.get(currNode)){
                 int adjNode=pr.node;
                 int nextCost=currCost+pr.cost;
                 if(nextCost<minCost[adjNode]){
                    minCost[adjNode]=nextCost;
                    pq.offer(new Pair(nextCost,adjNode));
                 }
            }
        }
        return -1;
    }
}