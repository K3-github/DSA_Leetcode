class DSU{
    List<Integer> par=new ArrayList<>();
    List<Integer> size=new ArrayList<>();

    DSU(int n){
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
}
class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n=arr.length;
        DSU ds=new DSU(n);
        for(int i=0;i<n;i++){
            int u=i,v=(i+k)%n;
            ds.unionBySize(u,v);
        }
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int ulp=ds.findUlp(i);
            List<Integer> li=mp.get(ulp);
            if(li==null){
                mp.put(ulp,new ArrayList<>());
            }
            mp.get(ulp).add(i);
        }
        long ans=0;
        for(Map.Entry<Integer,List<Integer>> e: mp.entrySet()){
            List<Integer> values=new ArrayList<>();
            List<Integer> indexs=e.getValue();
            int size=indexs.size();
            for(int i=0;i<size;i++){
                int ind=indexs.get(i);
                values.add(arr[ind]);
            }
            Collections.sort(values);
            int mid=values.get(size/2);
            long cost=0;
            for(int i=0;i<size;i++){
                cost+=Math.abs(values.get(i)-mid);
            }
            ans+=cost;
        }
        return ans;
    }
}