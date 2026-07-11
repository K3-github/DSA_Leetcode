class Solution {
    int nn=0,ne=0;
    private void solve(int node,List<List<Integer>> graph,boolean[] vis,HashSet<String> st){
        if(vis[node]==true) return;

        vis[node]=true;
        nn++;
        for(int adjNode: graph.get(node)){
            String str1=(node+'0')+"-"+(adjNode+'0');
            String str2=(adjNode+'0')+"-"+(node+'0');
            if(st.contains(str1) || st.contains(str2)) continue;
            ne++;
            st.add(str1);
            if(vis[adjNode]==false) solve(adjNode,graph,vis,st);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] vis=new boolean[n];
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
        for(int[] e: edges){
            int u=e[0],v=e[1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                HashSet<String> st=new HashSet<>();
                nn=0;ne=0;
                solve(i,g,vis,st);
                int me=nn*(nn-1)/2;
                if(ne==me) count++;
            }
        }
        return count;
    }
}
