class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] ind=new int[numCourses];
        for(int[] c: prerequisites){
            ind[c[0]]++;
            graph.get(c[1]).add(c[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i]==0) q.offer(i);
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            
            for(int adjNode: graph.get(node)){
                ind[adjNode]--;
                if(ind[adjNode]==0) q.offer(adjNode);
            }
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
             res[i]=ans.get(i);
        }
        return ans.size()==numCourses ? res : new int[]{};
    }
}