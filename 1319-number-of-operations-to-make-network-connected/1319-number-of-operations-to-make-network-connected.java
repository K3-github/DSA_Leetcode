class DisJointSet{
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisJointSet(int n){
        for(int i=0;i<=n;i++){
           parent.add(i);
           size.add(1);
        }
    }
    int findUlp(int node){
        if(node==parent.get(node)) return node;
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
            size.set(ulp_u,
                    size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,
                    size.get(ulp_u)+size.get(ulp_v));
        }
    }
};
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int ee=0;
        DisJointSet ds=new DisJointSet(n);
        for(int[] c: connections){
            int u=c[0],v=c[1];
            if(ds.findUlp(u)==ds.findUlp(v)){
                ee++;
                continue;
            }
            ds.unionBySize(u,v);
        }
        int cc=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) cc++;
        }
        if(ee>=cc-1) return cc-1;
        return -1;
    }
}