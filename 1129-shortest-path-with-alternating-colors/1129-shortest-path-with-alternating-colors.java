class Pair{
    int node;
    int color;

    Pair(int node,int color){
        this.node=node;
        this.color=color;
    }
};
class Solution {
    int INF=Integer.MAX_VALUE;
    private List<List<Pair>> createGraph(int n,int[][] redEdges,int[][] blueEdges){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: redEdges){
            int u=e[0],v=e[1];
            graph.get(u).add(new Pair(v,0));
        }
        for(int[] e: blueEdges){
            int u=e[0],v=e[1];
            graph.get(u).add(new Pair(v,1));
        }
        return graph;
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
         List<List<Pair>> graph=createGraph(n,redEdges,blueEdges);
         PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0] - b[0]);
         int[][] minLength=new int[n][3];
         for(int i=0;i<n;i++){
            Arrays.fill(minLength[i],INF);
         }
         minLength[0][2]=0;
         pq.offer(new int[]{0,0,2});

         while(pq.size()>0){
            int[] tp=pq.poll();
            int currLen=tp[0],currNode=tp[1],currColor=tp[2];

            if(minLength[currNode][currColor]<currLen) continue;

            for(Pair p: graph.get(currNode)){
                int adjNode=p.node;
                int nextColor=p.color;
                int nextLen=currLen+1;
                if(currColor!=nextColor && nextLen<minLength[adjNode][nextColor]){
                    minLength[adjNode][nextColor]=nextLen;
                    pq.offer(new int[]{nextLen,adjNode,nextColor});
                }
            }
         }
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            if(i==0) answer[i]=0;
            else{
                int len=Math.min(minLength[i][0],minLength[i][1]);
                answer[i]=(len==INF ? -1 : len);
            }
        }
        return answer;
    }
}