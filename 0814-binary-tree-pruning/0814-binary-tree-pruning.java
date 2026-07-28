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
    private TreeNode solve(TreeNode root){
        if(root==null) return null;

        root.left=solve(root.left);
        root.right=solve(root.right);

        if(root.left==null && root.right==null && root.val==0){
            root.left=null;
            root.right=null;
            return null;
        }
        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        return solve(root);
    }
}