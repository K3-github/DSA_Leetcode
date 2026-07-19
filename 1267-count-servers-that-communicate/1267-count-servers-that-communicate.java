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
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        DisJointSet ds=new DisJointSet(m+n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int u=i,v=n+j;
                    ds.unionBySize(u,v);
                }
            }
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int root = ds.findUlp(i);
                    count.put(root, count.getOrDefault(root, 0) + 1);
                }
            }
        }

        int ans=0;
        for (int val : count.values()) {
            if (val > 1)
                ans += val;
        }
        return ans;
    }
}