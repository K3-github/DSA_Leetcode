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
    private int[] height = new int[100001];
    private int[] ans = new int[100001];
    private int dfsHeight(TreeNode root) {
        if (root == null) return -1;

        int left = dfsHeight(root.left);
        int right = dfsHeight(root.right);

        return height[root.val] = 1 + Math.max(left, right);
    }
    private void dfs(TreeNode root, int depth, int rest) {
        if(root == null) return;
        ans[root.val] = rest;
        if (root.left != null) {
            int rightHeight = (root.right == null) ? -1 : height[root.right.val];
            dfs(root.left,depth + 1,Math.max(rest, depth + 1 + rightHeight));
        }
        if (root.right != null) {
            int leftHeight = (root.left == null) ? -1 : height[root.left.val];
            dfs(root.right,depth + 1,Math.max(rest, depth + 1 + leftHeight));
        }
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        dfsHeight(root);
        dfs(root, 0, 0);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = ans[queries[i]];
        }
        return res;
    }
}