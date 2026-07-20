class Solution {
    private int solve(int node,List<List<Integer>> graph,boolean[] vis,int[] quiet){
         vis[node]=true;
         int ans=500;
         for(Integer adjNode: graph.get(node)){
            if(!vis[adjNode]){
                ans=Math.min(ans,solve(adjNode,graph,vis,quiet));
            }
         }
         return Math.min(ans,quiet[node]);
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
        HashMap<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<n;i++){
            index.put(quiet[i],i);
        }
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[n];
            int mnQuiet=solve(i,graph,vis,quiet);
            answer[i]=index.get(mnQuiet);
        }
        return answer;
    }
}