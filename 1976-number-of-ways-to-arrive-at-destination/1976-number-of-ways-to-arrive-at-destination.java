class Pair{
    long first;
    int second;

    Pair(long first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] r: roads){
            graph.get(r[0]).add(new Pair(r[2],r[1]));
            graph.get(r[1]).add(new Pair(r[2],r[0]));
        }
        long[] time=new long[n];
        int[] ways=new int[n];
        for(int i=0;i<n;i++){
            time[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)-> Long.compare(a.first,b.first));
        q.offer(new Pair(0,0));
        ways[0]=1;time[0]=0;

        while(!q.isEmpty()){
            Pair tp=q.poll();
            int currNode=tp.second;
            long currTime=tp.first;

            if(currTime > time[currNode]) continue;

            for(Pair p: graph.get(currNode)){
                int adjNode=p.second;
                long reqTime=p.first;
                if(currTime+reqTime<time[adjNode]){
                    ways[adjNode]=ways[currNode];
                    time[adjNode]=currTime+reqTime;
                    q.offer(new Pair(time[adjNode],adjNode));
                }
                else if(currTime+reqTime==time[adjNode]){
                    ways[adjNode]=(ways[adjNode]+ways[currNode])%(1000000007);
                    ways[adjNode]%=1000000007;
                }
            }
        }
        if(time[n-1]==Integer.MAX_VALUE) return -1;
        return ways[n-1];
    }
}