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
    int mxDepth=1;
    int ans=0;
    private void solve(TreeNode root,int currDepth){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(currDepth>mxDepth){
                ans=root.val;
            }
            else if(currDepth==mxDepth){
                ans+=root.val;
            }
            mxDepth=Math.max(mxDepth,currDepth);
            return;
        }
        mxDepth=Math.max(mxDepth,currDepth);
        solve(root.left,currDepth+1);
        solve(root.right,currDepth+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        solve(root,1);
        return ans;
    }
}