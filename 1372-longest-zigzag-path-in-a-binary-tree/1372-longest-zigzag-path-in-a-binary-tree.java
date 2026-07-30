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
    private int solve(TreeNode root,int dir){
        if(root==null) return 0;

        int left=solve(root.left,-1);
        int right=solve(root.right,+1);
        
        ans=Math.max(ans,1+Math.max(left,right));
        if(dir==1) return 1+left;
        return 1+right;
    }
    public int longestZigZag(TreeNode root) {
        solve(root,0);
        return ans-1;
    }
}