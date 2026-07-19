class DisJointSet{
    List<Integer> par=new ArrayList<>();

    DisJointSet(int n){
        for(int i=0;i<n;i++){
            par.add(i);
        }
    }
    int findUlp(int node){
        if(par.get(node)==node) return node;
        int ulp=findUlp(par.get(node));
        par.set(node,ulp);
        return par.get(node);
    }
    void unionByMinParentVal(int u,int v){
        int ulp_u=findUlp(u);
        int ulp_v=findUlp(v);
        if(ulp_u==ulp_v) return;
        else if(ulp_u<ulp_v){
            par.set(ulp_v,ulp_u);
        }
        else{
            par.set(ulp_u,ulp_v);
        }
    }
};
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisJointSet ds=new DisJointSet(26);
        for(int i=0;i<s1.length();i++){
            int u=s1.charAt(i)-'a';
            int v=s2.charAt(i)-'a';
            ds.unionByMinParentVal(u,v);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            int node=baseStr.charAt(i)-'a';
            int mnValue=ds.findUlp(node);
            if(mnValue<node){
                sb.append((char)(mnValue+'a'));
            }
            else sb.append((char)(node+'a'));
        }
        return sb.toString();
    }
}