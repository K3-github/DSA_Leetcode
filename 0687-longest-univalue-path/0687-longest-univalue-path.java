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
    int ans=0;
    private int solve(TreeNode root){
        if(root==null) return 0;

        int left=solve(root.left);
        int right=solve(root.right);
        int res=1;
        if(root.left!=null && root.val==root.left.val){
            res+=left;
        }
        else left=0;
        if(root.right!=null && root.val==root.right.val){
            res+=right;
        }
        else right=0;
        ans=Math.max(ans,res);
        return 1+Math.max(left,right);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        solve(root);
        return ans-1;
    }
}