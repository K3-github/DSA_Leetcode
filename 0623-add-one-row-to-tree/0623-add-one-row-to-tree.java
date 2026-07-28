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
    private void solve(TreeNode root,int val,int depth,int currDepth){
        if(root==null) return;

        if(currDepth+1==depth){
            TreeNode leftNode=new TreeNode(val);
             TreeNode rightNode=new TreeNode(val);
            TreeNode rootLeft=root.left;
            TreeNode rootRight=root.right;
            root.left=leftNode;
            leftNode.left=rootLeft;
            root.right=rightNode;
            rightNode.right=rootRight;
            return;
        }

        solve(root.left,val,depth,currDepth+1);
        solve(root.right,val,depth,currDepth+1);
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        solve(root,val,depth,1);
        return root;
    }
}