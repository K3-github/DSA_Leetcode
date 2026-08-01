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
    int mx;
    int mn;

    Pair(int mx,int mn){
        this.mx=mx;
        this.mn=mn;
    }
};
class Solution {
    int ans=0;
    private Pair solve(TreeNode root){
       if(root.left==null && root.right==null){
           return new Pair(root.val,root.val);
       }
       int mx=root.val;
       int mn=root.val;
       if(root.left!=null){
          Pair left=solve(root.left);
          mx=Math.max(mx,left.mx);
          mn=Math.min(mn,left.mn);
       }
       if(root.right!=null){
          Pair right=solve(root.right);
          mx=Math.max(mx,right.mx);
          mn=Math.min(mn,right.mn);
       }

       ans=Math.max(ans,Math.max(Math.abs(root.val-mn),Math.abs(root.val-mx)));
       return new Pair(mx,mn);
    }
    public int maxAncestorDiff(TreeNode root) {
        solve(root);
        return ans;
    }
}