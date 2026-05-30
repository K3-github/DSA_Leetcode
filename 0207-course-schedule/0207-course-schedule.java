class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] ind=new int[numCourses];
        for(int[] c: prerequisites){
            ind[c[1]]++;
            graph.get(c[0]).add(c[1]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(ind[i]==0) q.offer(i);
        }
        
        int count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            
            for(int adjNode: graph.get(node)){
                ind[adjNode]--;
                if(ind[adjNode]==0) q.offer(adjNode);
            }
        }
        return count==numCourses ? true : false;
    }
}