class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n=graph.length;
        List<List<Integer>> rev=new ArrayList<>();
        for(int i=0;i<n;i++){
             rev.add(new ArrayList<>());
        } 
        for(int i=0;i<n;i++){
            for(int node: graph[i]){
                rev.get(node).add(i);
            }
        }

        int[] ind=new int[n];

        for(int i=0;i<n;i++){
            for(int node: rev.get(i)) ind[node]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0) q.offer(i);
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            
            for(int adjNode: rev.get(node)){
                ind[adjNode]--;
                if(ind[adjNode]==0) q.offer(adjNode);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}