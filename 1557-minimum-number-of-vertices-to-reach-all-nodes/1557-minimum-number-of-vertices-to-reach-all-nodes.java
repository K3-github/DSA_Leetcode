class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] ind=new int[n];
        for(int i=0;i<edges.size();i++){
            int v=edges.get(i).get(1);
            ind[v]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0) ans.add(i);
        }
        return ans;
    }
}