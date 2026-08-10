class Solution {
    int[] depth;
    int h;
    private List<List<Integer>> createTree(int[] p,int n){
        List<List<Integer>> tree=new ArrayList<>();
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(p[i]==-1) continue;
            int u=p[i],v=i;
            tree.get(u).add(v);
        }
        return tree;
    }
    private void calDepth(int node,List<List<Integer>> tree,int d){
        depth[node]=d;
        h=Math.max(h,d);
        for(Integer child: tree.get(node)){
            if(depth[child]==0) calDepth(child,tree,d+1);
        }
    }
    public long weightedSum(int[] parent, int[] nums) {
        int n=parent.length;
        depth=new int[n];
        h=0;
        calDepth(0,createTree(parent,n),1);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int fact=h-depth[i]+1;
            ans+=(long)nums[i]*(long)fact;
        }
        return ans;
    }
}
