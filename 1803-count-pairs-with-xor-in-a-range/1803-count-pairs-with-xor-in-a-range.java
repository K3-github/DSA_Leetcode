class Node{
    Node[] links=new Node[2];
    int count=0;
}
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
            node.count++;
        }
    }
    private int getPairs(int num,int limit){
        Node node=root;
        int ans=0;

        for(int i=31;i>=0;i--){
            if(node==null) break;

            int bitNum=(num>>i)&1;
            int bitLimit=(limit>>i)&1;

            if(bitLimit==1){
                if(node.links[bitNum]!=null){
                    ans+=node.links[bitNum].count;
                }
                node=node.links[1-bitNum];
            }
            else{
                node=node.links[bitNum];
            }
        }
        if(node!=null) ans+=node.count;
        return ans;
    }
    public int countPairs(int[] nums, int low, int high) {
         int n=nums.length;
         int ans=0;
         for(int i=0;i<n;i++){
            ans+=getPairs(nums[i],high);
            ans-=getPairs(nums[i],low-1);
            insert(nums[i]);
         }
         return ans;
    }
}