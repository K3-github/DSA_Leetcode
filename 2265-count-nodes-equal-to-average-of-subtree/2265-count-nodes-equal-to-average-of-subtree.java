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
    int noOfNodes;
    int subTreeSum;

    Pair(int noOfNodes,int subTreeSum){
        this.noOfNodes=noOfNodes;
        this.subTreeSum=subTreeSum;
    }
}; 
class Solution {
    int count=0;
    private Pair solve(TreeNode root){
        if(root==null) return new Pair(0,0);

        Pair left=solve(root.left);
        Pair right=solve(root.right);
        
        int totalSubTreeSum=root.val+left.subTreeSum+right.subTreeSum;
        int totalNodes=1+left.noOfNodes+right.noOfNodes;
        int avg=totalSubTreeSum/totalNodes;
        if(avg==root.val) count++;
        return new Pair(totalNodes,totalSubTreeSum);
    }
    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return count;
    }
}