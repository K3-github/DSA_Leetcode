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
    private boolean solve(TreeNode root,TreeNode par,int dir){
        if(root==null) return false;

        boolean left=solve(root.left,root,0);
        boolean right=solve(root.right,root,1);

        if(left==false && right==false && root.val==0){
            if(par==null) return false;
            if(dir==0) par.left=null;
            else par.right=null;
            return false;
        }
        return true;
    }
    public TreeNode pruneTree(TreeNode root) {
        boolean res=solve(root,null,-1);
        return res==false ? null : root;
    }
}