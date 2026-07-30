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
class Pair{
    TreeNode node;
    int height;

    Pair(TreeNode node,int height){
        this.node=node;
        this.height=height;
    }
};
class Solution {
    private Pair solve(TreeNode root){
        if(root==null) return new Pair(null,0);
        if(root.left==null && root.right==null){
            return new Pair(root,1);
        }

        Pair left=solve(root.left);
        Pair right=solve(root.right);
        
        if(left.height==right.height){
            if(left!=null && right!=null) return new Pair(root,1+left.height);
            else if(left==null) return new Pair(right.node,1+left.height);
            else if(right==null) return new Pair(left.node,1+left.height);
            return new Pair(null,1+left.height);
        }
        int mxHeight=Math.max(left.height,right.height);
        if(mxHeight==left.height) return new Pair(left.node,1+mxHeight);
        return new Pair(right.node,1+mxHeight);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root).node;
    }
}