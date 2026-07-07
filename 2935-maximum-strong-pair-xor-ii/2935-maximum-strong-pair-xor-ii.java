class Node{
    Node[] links=new Node[2];
    int count=0;

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
            node.count++;
        }
    }
    private int getMax(int num){
        Node node=root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.links[1-bit]!=null && node.links[1-bit].count>0){
                ans=ans | (1<<i);
                node=node.links[1-bit];
            }
            else node=node.links[bit];
        }
        return ans;
    }
    private void remove(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            node=node.links[bit];
            node.count--;
        }
    }
    public int maximumStrongPairXor(int[] nums) {
        int ans=0;
        int n=nums.length;
        Arrays.sort(nums);
        int i=0,curr=0,j=0;
        while(curr<n){
            while(j<n && (nums[j]<=2*nums[curr])){
                insert(nums[j]);
                j++;
            }
            while(i<j && nums[curr]>2*nums[i]){
                remove(nums[i]);
                i++;
            }
            ans=Math.max(ans,getMax(nums[curr]));
            curr++;
        }
        return ans;
    }
}