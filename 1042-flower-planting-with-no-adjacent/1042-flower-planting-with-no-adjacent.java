class Solution {
    private List<List<Integer>> createGraoh(int n,int[][] paths){
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] p: paths){
            int u=p[0]-1,v=p[1]-1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        return g;
    }
    private void dfs(int node,List<List<Integer>> graph,int[] answer){
           if(answer[node]!=-1) return;
           HashSet<Integer> color=new HashSet<>();
           for(Integer adjNode: graph.get(node)){
                  color.add(answer[adjNode]);
           }
           for(int i=1;i<=4;i++){
              if(!color.contains(i)){
                answer[node]=i;
                break;
              }
           }
           for(Integer adjNode: graph.get(node)){
               if(answer[adjNode]!=-1){
                  dfs(adjNode,graph,answer);
               }
           }
    }
    public int[] gardenNoAdj(int n, int[][] paths) {
         List<List<Integer>> graph=createGraoh(n,paths);
         int[] answer=new int[n];
         Arrays.fill(answer,-1);
         for(int i=0;i<n;i++){
            if(answer[i]==-1){
                dfs(i,graph,answer);
            }
         }
         return answer;
    }
}