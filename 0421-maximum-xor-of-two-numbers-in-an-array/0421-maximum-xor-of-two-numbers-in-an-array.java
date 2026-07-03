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
    }
    private int getMax(int num){
        int ans=0;
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.links[1-bit]!=null){
                ans|=(1<<i);
                node=node.links[1-bit];
            }
            else node=node.links[bit];
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            insert(nums[i]);
        }
        for(int i=0;i<n;i++){
            ans=Math.max(ans,getMax(nums[i]));
        }
        return ans;
    }
}