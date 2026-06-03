class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] t: times){
            graph.get(t[0]-1).add(new Pair(t[1]-1,t[2]));
        }
        int[] time=new int[n];
        for(int i=0;i<n;i++){
            time[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)-> a.first - b.first);
        q.offer(new Pair(0,k-1));
        time[k-1]=0;

        while(!q.isEmpty()){
            Pair tp=q.poll();
            int currTime=tp.first;
            int currNode=tp.second;

            if(currTime>time[currNode]) continue;

            for(Pair p: graph.get(currNode)){
                int adjNode=p.first;
                int reqTime=p.second;

                if(currTime+reqTime<time[adjNode]){
                    time[adjNode]=currTime+reqTime;
                    q.offer(new Pair(time[adjNode],adjNode));
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
           if(time[i]==Integer.MAX_VALUE) return -1;
           ans=Math.max(ans,time[i]);
        }
        return ans;
    }
}