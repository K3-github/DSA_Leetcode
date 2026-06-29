class Solution {
    private int solve(int node,List<List<Integer>> graph,boolean[] vis){
        if(vis[node]==true) return 0;
        
        vis[node]=true;
        int ans=0;
        for(int adjNode: graph.get(node)){
            if(!vis[adjNode]){
                ans+=solve(adjNode,graph,vis);
            }
        }
        return 1+ans;
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] arr: edges){
            int u=arr[0],v=arr[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        List<Integer> cSize=new ArrayList<>();
        long currSum=0;
        long ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
               int currNum=solve(i,g,vis);
               ans+=(currSum*currNum);
               currSum+=currNum;
            }
        }
        // long currSum=0;
        // long ans=0;
        // for(int i=cSize.size()-1;i>=0;i--){
        //     int currNum=cSize.get(i);
        //      ans+=(currSum*currNum);
        //      currSum+=currNum;
        // }
        return ans;
    }
}

