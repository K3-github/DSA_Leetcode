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
    List<TreeNode> ans=new ArrayList<>();
    HashMap<String,Integer> mp=new HashMap<>();
    private String solve(TreeNode root){
        if(root==null) return "#";

        String left=solve(root.left);
        String right=solve(root.right);

        String s=root.val+','+left+right;
        if(mp.containsKey(s) && mp.get(s)==1){
            ans.add(root);
        }
        mp.put(s,mp.getOrDefault(s,0)+1);
        return s;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return ans;
    }
}