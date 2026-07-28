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
    private TreeNode solve(int[] nums,int low,int high){
        if(low>high) return null;
        int mxValue=-1,mxValueInd=0;
        for(int i=low;i<=high;i++){
            if(mxValue<nums[i]){
                mxValue=nums[i];
                mxValueInd=i;
            }
        }
        TreeNode root=new TreeNode(nums[mxValueInd]);
        root.left=solve(nums,low,mxValueInd-1);
        root.right=solve(nums,mxValueInd+1,high);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
}