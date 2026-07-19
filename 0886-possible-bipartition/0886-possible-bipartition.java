class Solution {
    private boolean solve(int node,List<List<Integer>> graph,int[] color){
        
        for(Integer adjNode: graph.get(node)){
            if(color[adjNode]==-1){
                color[adjNode]=1-color[node];
                if(solve(adjNode,graph,color)==false){
                    return false;
                }
            }
            else if(color[adjNode]==color[node]) return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++){
            int u=dislikes[i][0]-1;
            int v=dislikes[i][1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(solve(i,graph,color)==false) return false;
            }
        }
        return true;
    }
}