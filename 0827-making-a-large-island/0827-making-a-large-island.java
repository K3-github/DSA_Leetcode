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
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisJointSet ds=new DisJointSet(n*n);
        int[] drow=new int[]{0,+1,0,-1};
        int[] dcol=new int[]{+1,0,-1,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;

                for(int d=0;d<4;d++){
                    int nrow=i+drow[d];
                    int ncol=j+dcol[d];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        int u=n*i+j;
                        int v=n*nrow+ncol;
                        ds.unionBySize(u,v);
                    }
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashMap<Integer,Integer> mp=new HashMap<>();
                    for(int d=0;d<4;d++){
                        int nrow=i+drow[d];
                        int ncol=j+dcol[d];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                            int node=n*nrow+ncol;
                            int parent=ds.findUlp(node);
                            mp.putIfAbsent(parent,ds.size.get(parent));
                        }
                    }
                    int sum=0;
                    for(Map.Entry<Integer,Integer> e: mp.entrySet()){
                        int val=e.getValue();
                        sum+=val;
                    }
                    ans=Math.max(ans,1+sum);    
                }
            }
        }
        for(int i=0;i<n*n;i++) ans=Math.max(ans,ds.size.get(ds.findUlp(i)));
        return ans;
    }
}

