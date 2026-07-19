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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisJointSet ds=new DisJointSet(n+1);
        HashMap<String,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
           for(int j=1;j<accounts.get(i).size();j++){
              String email=accounts.get(i).get(j);
              if(mp.containsKey(email)){
                  ds.unionBySize(i,mp.get(email));
              }
              else{
                 mp.put(email,i);
              }
           }
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(Map.Entry<String,Integer> e: mp.entrySet()){
            int node=e.getValue();
            String email=e.getKey();
            int ulp=ds.findUlp(node);
            ans.get(ulp).add(email);
        }
        for(int i=0;i<n;i++){
           if(ans.get(i).size()==0) continue;
            Collections.sort(ans.get(i));
            ans.get(i).add(0, accounts.get(i).get(0));
        }
        ans.removeIf(List::isEmpty);
        return ans;
    }
}