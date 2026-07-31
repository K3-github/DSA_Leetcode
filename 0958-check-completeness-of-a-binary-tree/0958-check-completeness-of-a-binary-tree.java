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
    private int count(TreeNode root){
        if(root==null) return 0;
        return 1+count(root.left)+count(root.right);
    }
    private boolean check(TreeNode root,int index){
        if(root==null) return true;
        if(index>total) return false;

        return check(root.left,2*index) && check(root.right,2*index+1);
    }
    public boolean isCompleteTree(TreeNode root) {
        total=count(root);
        return check(root,1);
    }
}