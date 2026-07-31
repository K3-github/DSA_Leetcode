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
    List<Integer> ans=new ArrayList<>();
    int index=0;
    private boolean solve(TreeNode root,int[] v){
       if(root==null) return true;
       if(root.val!=v[index]) return false;

       index++;
       if(root.left!=null && index<v.length && root.left.val!=v[index]){
            ans.add(root.val);
            return solve(root.right,v) && solve(root.left,v);
       }
       return solve(root.left,v) && solve(root.right,v);
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(solve(root,voyage)) return ans;
        return List.of(-1);
    }
}