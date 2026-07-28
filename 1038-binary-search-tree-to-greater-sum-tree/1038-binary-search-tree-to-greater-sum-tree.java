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
    int total=0;
    private void solve(TreeNode root){
        if(root==null) return;
        solve(root.right);
        int org=root.val;
        root.val=root.val+total;
        total+=org;
        solve(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        solve(root);
        return root;
    }
}