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
    private List<TreeNode> solve(int low,int high){
        List<TreeNode> ans=new ArrayList<>();
        if(low>high){
           ans.add(null);
           return ans;
        }
        for(int root=low;root<=high;root++){
            List<TreeNode> leftSubTrees=solve(low,root-1);
            List<TreeNode> rightSubTrees=solve(root+1,high);

            for(TreeNode left: leftSubTrees){
                for(TreeNode right: rightSubTrees){
                    TreeNode node=new TreeNode(root);
                    node.left=left;
                    node.right=right;
                    ans.add(node);
                }
            }
        }
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return solve(1,n);
    }
}