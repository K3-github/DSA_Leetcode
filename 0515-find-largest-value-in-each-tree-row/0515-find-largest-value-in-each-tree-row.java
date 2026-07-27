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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;

        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            int mx=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                mx=Math.max(mx,node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            result.add(mx);
        }
        return result;
    }
}