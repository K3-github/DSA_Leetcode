/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> st=new Stack<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            TreeNode node=new TreeNode(nums[i]);
            if(st.size()>0){
                while(st.size()>0 && st.peek().val<nums[i]){
                    node.left = st.pop();
                }
                if(st.size()>0){
                    st.peek().right=node;
                }
            }
            st.push(node);
        }
        while (st.size() > 1) {
            st.pop();
        }
        return st.peek();
    }
}