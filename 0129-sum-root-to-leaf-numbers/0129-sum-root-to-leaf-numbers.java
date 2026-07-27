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
    private int solve(TreeNode root,int curr){
        if(root==null) return 0;
        curr=10*curr+root.val;
        if(root.left==null && root.right==null) return curr;
        return solve(root.left,curr)+solve(root.right,curr);
    }
    public int sumNumbers(TreeNode root) {
        return solve(root,0);
    }
}