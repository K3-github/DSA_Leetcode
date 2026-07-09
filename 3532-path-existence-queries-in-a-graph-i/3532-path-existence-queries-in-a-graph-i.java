class DisJointSet{
     List<Integer> par=new ArrayList<>();
     List<Integer> size=new ArrayList<>();

     DisJointSet(int n){
        for(int i=0;i<=n;i++){
            par.add(i);
            size.add(1);
        }
     }
    public int findUlp(int node){
        if(par.get(node)==node) return node;
        int ulp=findUlp(par.get(node));
        par.set(node,ulp);
        return par.get(node);
    }
    public void unionBySize(int u,int v){
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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] ans=new boolean[queries.length];
        DisJointSet ds=new DisJointSet(n);
        for(int i=0;i<n;i++){
            while(i+1<n && nums[i+1]-nums[i]<=maxDiff){
                ds.unionBySize(i,i+1);
                i++;
            }
        }
        for(int i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            if(ds.findUlp(u)==ds.findUlp(v)){
                ans[i]=true;
            }
        }
        return ans;
    }
}