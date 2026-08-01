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

    private String ans = null;

    private void dfs(TreeNode root, StringBuilder path) {
        if (root == null) return;
        path.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            path.reverse();
            String curr = path.toString();
            if (ans == null || curr.compareTo(ans) < 0) {
                ans = curr;
            }
            path.reverse();
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.deleteCharAt(path.length() - 1);
    }
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
}