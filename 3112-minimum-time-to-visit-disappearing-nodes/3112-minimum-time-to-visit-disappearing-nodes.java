class Pair{
    int time;
    int node;

    Pair(int time,int node){
        this.time=time;
        this.node=node;
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
          int u=e[0],v=e[1],time=e[2];
          graph.get(u).add(new Pair(time,v));
          graph.get(v).add(new Pair(time,u));
       }
       return graph;
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<Pair>> graph=createGraph(n,edges);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.time - b.time);
        int[] minTime=new int[n];
        Arrays.fill(minTime,INF);
        minTime[0]=0;
        pq.offer(new Pair(0,0));

        while(pq.size()>0){
            Pair p=pq.poll();
            int currTime=p.time;
            int currNode=p.node;
            
            if(currTime>=disappear[currNode] || currTime>minTime[currNode]){
                continue;
            }

            for(Pair pr: graph.get(currNode)){
                 int childNode=pr.node;
                 int nextTime=pr.time+currTime;
                 if(nextTime<minTime[childNode] && nextTime<disappear[childNode]){
                    minTime[childNode]=nextTime;
                    pq.offer(new Pair(nextTime,childNode));
                 }
            }
        }
        for(int i=0;i<n;i++){
            if(minTime[i]>=disappear[i]) minTime[i]=-1;
        }
        return minTime;
    }
}