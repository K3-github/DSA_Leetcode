class DisJointSet{
    List<Integer> par=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DisJointSet(int n){
        for(int i=0;i<=n;i++){
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
        if(ulp_u==ulp_v) return;
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
    public boolean equationsPossible(String[] equations) {
        DisJointSet ds=new DisJointSet(26);
        for(String str: equations){
            int u=str.charAt(0)-'a';
            int v=str.charAt(3)-'a';
            if(str.charAt(1)=='='){
                ds.unionBySize(u,v);
            }
        }
        for(String str: equations){
            int u=str.charAt(0)-'a';
            int v=str.charAt(3)-'a';
            if(str.charAt(1)=='!'){
                if(ds.findUlp(u)==ds.findUlp(v)) return false;
            }
        }
        return true;
    }
}