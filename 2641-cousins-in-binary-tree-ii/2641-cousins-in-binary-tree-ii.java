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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        root.val=0;
        int nextLevelSum=0;
        if(root.left!=null) nextLevelSum+=root.left.val;
        if(root.right!=null) nextLevelSum+=root.right.val;

        while(!q.isEmpty()){
            int size=q.size();
            int currLevelSum=0;
            for(int i=0;i<size;i++){
                int prev=nextLevelSum;
                TreeNode node=q.poll();
                if(node.left!=null) prev-=node.left.val;
                if(node.right!=null) prev-=node.right.val;

                if(node.left!=null){
                    q.offer(node.left);
                    if(node.left.left!=null){
                        currLevelSum+=node.left.left.val;
                    }
                    if(node.left.right!=null){
                        currLevelSum+=node.left.right.val;
                    }
                    node.left.val=prev;
                }
                if(node.right!=null){
                    q.offer(node.right);
                    if(node.right.left!=null){
                        currLevelSum+=node.right.left.val;
                    }
                    if(node.right.right!=null){
                        currLevelSum+=node.right.right.val;
                    }
                    node.right.val=prev;
                }

            }
            nextLevelSum=currLevelSum;
        }
        return root;
    }
}