class DisJointSet{
    private List<Integer> parent=new ArrayList<>();
    private List<Integer> size=new ArrayList<>();
    
    DisJointSet(int n){
      for(int i=0;i<n;i++){
        parent.add(i);
        size.add(1);
      }
    }

    int findUlp(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp=findUlp(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    void unionBySize(int u,int v){
        int ulp_u=findUlp(u);
        int ulp_v=findUlp(v);

        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
    }
};
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisJointSet ds=new DisJointSet(n);

        for(int[] e: edges){
            int u=e[0]-1,v=e[1]-1;
            if(ds.findUlp(u)==ds.findUlp(v)){
                return e;
            }
            else{
                ds.unionBySize(u,v);
            }
        }
        return new int[]{-1,-1};
    }
}