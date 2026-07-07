class Node{
    Node[] links=new Node[2];

    Node(){}
};
class Solution {
    private Node root=new Node();
    private void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.links[bit]==null){
                node.links[bit]=new Node();
            }
            node=node.links[bit];
        }
        return;
    }
    private int getMax(int x){
        Node node=root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit=(x>>i)&1;
            if(node.links[1-bit]!=null){
                ans=ans | (1<<i);
                node=node.links[1-bit];
            }
            else node=node.links[bit];
        }
        return ans;
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
         int n=queries.length;
         int[] ans=new int[n];
         Arrays.sort(nums);
         int[][] qs=new int[n][3];
         for(int i=0;i<n;i++){
            qs[i]=new int[]{queries[i][0],queries[i][1],i};
         }
         Arrays.sort(qs,(a,b)-> a[1]-b[1]);
         int j=0;
         for(int i=0;i<n;i++){
            int x=qs[i][0];
            int m=qs[i][1];
            while(j<nums.length && nums[j]<=m){
                 insert(nums[j]);
                 j++;
            }
            int index=qs[i][2];
            int xr=-1;
            if(j>0) xr=getMax(x);
            ans[index]=xr;
         }
         return ans;
    }
}