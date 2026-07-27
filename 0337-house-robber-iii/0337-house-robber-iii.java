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
    private int solve(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);

        int pick=root.val;
        if(root.left!=null){
            pick+=solve(root.left.left,dp)+solve(root.left.right,dp);
        }
        if(root.right!=null){
            pick+=solve(root.right.left,dp)+solve(root.right.right,dp);
        }
        int notPick=solve(root.left,dp)+solve(root.right,dp);
        dp.put(root,Math.max(pick,notPick));
        return dp.get(root);
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> dp=new HashMap<>();
        return solve(root,dp);
    }
}