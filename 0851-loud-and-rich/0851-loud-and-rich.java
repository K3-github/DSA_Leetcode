class Solution {
    int ans;
    int mnQ;
    private void solve(int node,List<List<Integer>> graph,boolean[] vis,int[] quiet){
         vis[node]=true;

         if(quiet[node]<mnQ){
            mnQ=quiet[node];
            ans=node;
         }
         for(Integer adjNode: graph.get(node)){
            if(!vis[adjNode]){
                solve(adjNode,graph,vis,quiet);
            }
         }
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph=new ArrayList<>();
        int n=quiet.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e: richer){
            graph.get(e[1]).add(e[0]);
        }
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[n];
            ans=i;
            mnQ=quiet[i];
            solve(i,graph,vis,quiet);
            answer[i]=ans;
        }
        return answer;
    }
}