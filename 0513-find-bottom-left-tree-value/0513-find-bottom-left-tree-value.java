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
    int mxDepth=-1;
    int ans=0;
    private void solve(TreeNode root,int depth){
        if(root==null) return;

        if(depth>mxDepth) ans=root.val;
        mxDepth=Math.max(mxDepth,depth);

        solve(root.left,depth+1);
        solve(root.right,depth+1);
    }
    public int findBottomLeftValue(TreeNode root) {
        solve(root,0);
        return ans;
    }
}