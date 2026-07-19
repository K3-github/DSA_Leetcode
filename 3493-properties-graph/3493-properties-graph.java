class DisJointSet{
    List<Integer> par=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisJointSet(int n){
        for(int i=0;i<n;i++){
            par.add(i);
            size.add(1);
        }
    }
    int findUlp(int node){
        if(par.get(node)==node) return node;
        int ulp=findUlp(par.get(node));
        par.set(node,ulp);
        return par.get(node);
    }
    void unionBySize(int u,int v){
        int ulp_u=findUlp(u);
        int ulp_v=findUlp(v);
        if(ulp_v==ulp_u) return;
        else if(size.get(ulp_u)<size.get(ulp_v)){
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            par.set(ulp_u,ulp_v);
        }
        else{
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            par.set(ulp_v,ulp_u);
        }
    }
};
class Solution {
    private int intersect(int[] a,int[] b){
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<a.length;i++){
            st.add(a[i]);
        }
        int count=0;
        for(int i=0;i<b.length;i++){
            if(st.contains(b[i])){
                count++;
                st.remove(b[i]);
            }
        }
        return count;
    }
    public int numberOfComponents(int[][] properties, int k) {
        int n=properties.length;
        DisJointSet ds=new DisJointSet(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(intersect(properties[i], properties[j]) >= k){
                    ds.unionBySize(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(ds.findUlp(i)==i) count++;
        }
        return count;
    }
}