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
    private int countNoc(int n,int[][] edges,int t){
        DisJointSet ds=new DisJointSet(n);
        for(int[] e: edges){
            int u=e[0],v=e[1];
            if(e[2]>t) ds.unionBySize(u,v);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(ds.findUlp(i)==i) count++;
        }
        return count;
    }
    public int minTime(int n, int[][] edges, int k) {
        int low=0,high=1000000000;
        while(low<=high){
            int t=(low+high) >> 1;
            int cnt=countNoc(n,edges,t);
            if(cnt>=k) high=t-1;
            else low=t+1;
        }
        return low;
    }
}