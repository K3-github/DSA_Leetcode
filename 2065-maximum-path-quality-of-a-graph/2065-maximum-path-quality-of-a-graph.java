class Solution {
    class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    int ans=0;
    private void dfs(int node,int time,int quality,int[] values,int[] vis,List<List<Pair>> graph,int maxTime){
        if(time>maxTime) return;

        if(node==0){
            ans=Math.max(ans,quality);
        }

        for(Pair p:graph.get(node)){
            int nextNode=p.node;
            int nextTime=time+p.time;

            if(nextTime<=maxTime){

                int add=0;

                if(vis[nextNode]==0){
                    add=values[nextNode];
                }

                vis[nextNode]++;

                dfs(nextNode,nextTime,quality+add,values,vis,graph,maxTime);

                vis[nextNode]--;
            }
        }
    }
    public int maximalPathQuality(int[] values,int[][] edges,int maxTime) {
        int n=values.length;

        List<List<Pair>> graph=new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e:edges){
            graph.get(e[0]).add(new Pair(e[1],e[2]));
            graph.get(e[1]).add(new Pair(e[0],e[2]));
        }

        int[] vis=new int[n];
        vis[0]=1;

        dfs(0,0,values[0],values,vis,graph,maxTime);

        return ans;
    }
}