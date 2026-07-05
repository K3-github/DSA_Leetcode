class Pair{
    int node;
    int cost;

    Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
};
class Solution {
    private boolean isPossible(int node,int dest,int mid,int curr,long k,List<List<Pair>> graph,boolean[] online){
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0] - b[0]);
         int[] dist=new int[dest+1];
         Arrays.fill(dist,Integer.MAX_VALUE);
         pq.offer(new int[]{0,node});
         dist[node]=0;

         while(pq.size()>0){
            int[] tp=pq.poll();
            int currCost=tp[0],currNode=tp[1];

            if(currNode==dest) return true;
            if(currCost>dist[currNode]) continue;

            for(Pair p: graph.get(currNode)){
                int adjNode=p.node;
                int reqCost=p.cost;

                if(reqCost>=mid && online[adjNode]==true && currCost+reqCost<=k && currCost+reqCost<dist[adjNode]){
                    dist[adjNode]=currCost+reqCost;
                    pq.offer(new int[]{dist[adjNode],adjNode});
                }
            }
         }
         return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        List<List<Pair>> graph=new ArrayList<>();
        int low=0,high=1000000000;
        int n=online.length;
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] e: edges){
            int u=e[0],v=e[1],c=e[2];
            graph.get(u).add(new Pair(v,c));
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(0,n-1,mid,0,k,graph,online)){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }
}