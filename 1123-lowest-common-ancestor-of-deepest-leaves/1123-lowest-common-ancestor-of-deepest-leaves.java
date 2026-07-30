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
    private int getMaxDepth(TreeNode root){
        if(root==null) return 0;

        int left=getMaxDepth(root.left);
        int right=getMaxDepth(root.right);

        return 1+Math.max(left,right);
    }
    private TreeNode solve(TreeNode root,int maxDepth,int currDepth){
        if(root==null) return null;
        if(root.left==null && root.right==null){
            if(currDepth==maxDepth) return root;
            return null;
        }

        TreeNode left=solve(root.left,maxDepth,currDepth+1);
        TreeNode right=solve(root.right,maxDepth,currDepth+1);

        if(left!=null && right!=null) return root;
        else if(left==null) return right;
        else if(right==null) return left;
        return null;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth=getMaxDepth(root);
        return solve(root,maxDepth,1);
    }
}