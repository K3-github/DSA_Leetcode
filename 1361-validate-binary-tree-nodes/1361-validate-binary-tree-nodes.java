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
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        DisJointSet ds=new DisJointSet(n);
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1){
                if(ds.findUlp(i)==ds.findUlp(leftChild[i])) return false;
                ds.unionBySize(i,leftChild[i]);
            }
            if(rightChild[i]!=-1){
                if(ds.findUlp(i)==ds.findUlp(rightChild[i])) return false;
                ds.unionBySize(i,rightChild[i]);
            }

        }
        int count=0;
        for(int i=0;i<n;i++){
            if(ds.findUlp(i)==i) count++;
            if(count>1) return false;
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1){
                indegree[leftChild[i]]++;
                if(indegree[leftChild[i]]>1) return false;
            }
            if(rightChild[i]!=-1){
                indegree[rightChild[i]]++;
                if(indegree[rightChild[i]]>1) return false;
            }
        }
        return count==1;
    }
}