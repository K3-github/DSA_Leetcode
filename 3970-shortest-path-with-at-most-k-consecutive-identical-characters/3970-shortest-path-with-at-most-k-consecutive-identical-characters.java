class Pair{
    int node;
    int w;

    Pair(int node,int w){
        this.node=node;
        this.w=w;
    }
};
class Solution {
    int INF=Integer.MAX_VALUE;
    private List<List<Pair>> createGraph(int n,int[][] edges){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1],w=e[2];
            graph.get(u).add(new Pair(v,w));
        }
        return graph;
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<Pair>> graph=createGraph(n,edges);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[][] minEdgeWeight=new int[n][k+1];
        for(int i=0;i<n;i++){
           Arrays.fill(minEdgeWeight[i],INF);
        }
        minEdgeWeight[0][k-1]=0;
        pq.offer(new int[]{0,0,k-1});

        while(pq.size()>0){
            int[] tp=pq.poll();
            int currW=tp[0],currNode=tp[1],remK=tp[2];

            if(currNode==n-1) return currW;
            if(currW>minEdgeWeight[currNode][remK]) continue;

            for(Pair p: graph.get(currNode)){
                int adjNode=p.node;
                int nextW=currW+p.w;
                if(labels.charAt(currNode)!=labels.charAt(adjNode)){
                    if(nextW<minEdgeWeight[adjNode][k-1]){
                        minEdgeWeight[adjNode][k-1]=nextW;
                        pq.offer(new int[]{nextW,adjNode,k-1});
                    }
                }
                else{
                    if(remK>0 && nextW<minEdgeWeight[adjNode][remK-1]){
                        minEdgeWeight[adjNode][remK-1]=nextW;
                        pq.offer(new int[]{nextW,adjNode,remK-1});
                    }
                }
            }
        }
        return -1;
    }
}