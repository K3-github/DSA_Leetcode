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
    int depth;

    Pair(int noOfNodes,int depth){
        this.noOfNodes=noOfNodes;
        this.depth=depth;
    }
}; 
class Solution {
    PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> a - b);
    private Pair solve(TreeNode root,int k){
        if(root==null) return new Pair(0,0);

        Pair left=solve(root.left,k);
        Pair right=solve(root.right,k);

        int currDepth=1+Math.max(left.depth,right.depth);
        int totalNodes=left.noOfNodes+right.noOfNodes+1;

        if(Math.pow(2,currDepth)-1==totalNodes){
            pq.offer(totalNodes);
            if(pq.size()>k) pq.poll();
        }
        return new Pair(totalNodes,currDepth);
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        solve(root,k);
        if(pq.size()<k) return -1;
        return pq.peek();
    }
}