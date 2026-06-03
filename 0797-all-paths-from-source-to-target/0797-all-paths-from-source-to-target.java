class Solution {
    List<List<Integer>> paths=new ArrayList<>();
    private void solve(int node,int target,int[][] graph,List<Integer> path){
        path.add(node);
        if(node==target){
            paths.add(new ArrayList<>(path));
        }
        for(int adjNode: graph[node]){
            solve(adjNode,target,graph,path);
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        List<Integer> path=new ArrayList<>();
        solve(0,n-1,graph,path);
        return paths;
    }
}