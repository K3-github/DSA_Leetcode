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
    private List<List<int[]>> createGraph(int n,int[][] edges){
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1],st=e[2],end=e[3];
            graph.get(u).add(new int[]{v,st,end});
        }
        return graph;
    }
    public int minTime(int n, int[][] edges) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.time - b.time);
        int[] minTime=new int[n];
        Arrays.fill(minTime,INF);
        List<List<int[]>> graph=createGraph(n,edges);
        pq.offer(new Pair(0,0));
        minTime[0]=0;

        while(pq.size()>0){
            Pair tp=pq.poll();
            int currTime=tp.time;
            int currNode=tp.node;

            if(currNode==n-1) return currTime;
            if(minTime[currNode]<currTime) continue;

            for(int[] arr: graph.get(currNode)){
                int adjNode=arr[0],start=arr[1],end=arr[2];
                if(currTime<=end){
                    int nextTime=Math.max(currTime,start)+1;
                    if(nextTime<minTime[adjNode]){
                        minTime[adjNode]=nextTime;
                        pq.offer(new Pair(nextTime,adjNode));
                    }
                }
            }
        }
        return -1;
    }
}