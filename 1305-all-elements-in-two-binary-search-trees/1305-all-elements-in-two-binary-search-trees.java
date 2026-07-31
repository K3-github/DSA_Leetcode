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
    private List<Integer> mergeTwoSortedList(List<Integer> in1,List<Integer> in2){
        int n=in1.size(),m=in2.size();
        int i=0,j=0;
        List<Integer> result=new ArrayList<>();
        while(i<n && j<m){
            if(in1.get(i)<=in2.get(j)){
                result.add(in1.get(i++));
            }
            else result.add(in2.get(j++));
        }
        while(i<n) result.add(in1.get(i++));
        while(j<m) result.add(in2.get(j++));
        return result;
    }
    private void inorderTrav(TreeNode root,List<Integer> res){
        if(root==null) return;

        inorderTrav(root.left,res);
        res.add(root.val);
        inorderTrav(root.right,res);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> in1=new ArrayList<>();
        List<Integer> in2=new ArrayList<>();
        
        inorderTrav(root1,in1);
        inorderTrav(root2,in2);
        return mergeTwoSortedList(in1,in2);
    }
}