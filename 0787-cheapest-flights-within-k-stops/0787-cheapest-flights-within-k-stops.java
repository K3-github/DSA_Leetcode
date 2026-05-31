class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] f: flights){
            graph.get(f[0]).add(new Pair(f[1],f[2]));
        }

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)-> a[0] - b[0]);
        q.offer(new int[]{0,src,0});
        int[] dist=new int[n];
        for(int i=0;i<n;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;

        while(!q.isEmpty()){
            int[] tp=q.poll();

            int stops=tp[0],currNode=tp[1],currPrice=tp[2];

            if(stops>k) continue;
            
            for(Pair p: graph.get(currNode)){
                int adjNode=p.first;
                int reqPrice=p.second;
                if(currPrice+reqPrice<dist[adjNode]){
                    dist[adjNode]=currPrice+reqPrice;
                    q.offer(new int[]{stops+1,adjNode,dist[adjNode]});
                }
            }
        }
        return dist[dst]==2147483647 ? -1: dist[dst];
    }
}