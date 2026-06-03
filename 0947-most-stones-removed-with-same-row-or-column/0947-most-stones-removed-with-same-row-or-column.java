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
         size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
       }
       else{
         parent.set(ulp_u,ulp_v);
         size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
       }
    }
};
class Solution {
    public int removeStones(int[][] stones) {
        int row=0;
        int col=0;
        for(int[] s :stones){
            row=Math.max(row,s[0]);
            col=Math.max(col,s[1]);
        }
        DisJointSet ds=new DisJointSet(row+1+col+1);
        for(int[] s: stones){
            int u=s[0];
            int v=row+s[1]+1;
            ds.unionBySize(u,v);
        }
        int count=0;
        for(int i=0;i<=row;i++){
           if(ds.parent.get(i)==i && ds.size.get(i)>1) count++;
        }
        for(int i=row+1;i<=row+col+1;i++){
           if(ds.parent.get(i)==i && ds.size.get(i)>1) count++;
        }
        return stones.length-count;
    }
}