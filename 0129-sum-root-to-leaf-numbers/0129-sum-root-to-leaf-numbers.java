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
    private void solve(TreeNode root,int pathNum){
        if(root==null) return;
        pathNum=10*pathNum+root.val;
        if(root.left==null && root.right==null){
            ans+=pathNum;
            return;
        }
        solve(root.left,pathNum);
        solve(root.right,pathNum);
    }
    public int sumNumbers(TreeNode root) {
        solve(root,0);
        return ans;
    }
}