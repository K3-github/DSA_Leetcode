class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        List<List<Pair>> graph=new ArrayList<>();
        int n=passingFees.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1],time=e[2];
            graph.get(u).add(new Pair(v,time));
            graph.get(v).add(new Pair(u,time));
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[][] minCost=new int[n][maxTime+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=maxTime;j++){
                minCost[i][j]=Integer.MAX_VALUE;
            }
        }
        pq.offer(new int[]{passingFees[0],0,0});
        minCost[0][0]=passingFees[0];

        while(pq.size()>0){
            int[] tp=pq.poll();
            int currCost=tp[0],currNode=tp[1],currTime=tp[2];

            if(currNode==n-1 && currTime<=maxTime) return currCost;
            if(currCost>minCost[currNode][currTime]) continue;

            for(Pair p: graph.get(currNode)){
                 int adjNode=p.first;
                 int reqTime=p.second;
                 int reqCost=passingFees[adjNode];
                 if((currTime+reqTime<=maxTime) && reqCost+currCost<minCost[adjNode][currTime+reqTime]){
                    minCost[adjNode][currTime+reqTime]=reqCost+currCost;
                    pq.offer(new int[]{minCost[adjNode][currTime+reqTime],adjNode,currTime+reqTime});
                 }
            }
        }
        return -1;
    }
}