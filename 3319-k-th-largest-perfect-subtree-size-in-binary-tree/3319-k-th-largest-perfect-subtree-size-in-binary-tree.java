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
    boolean isPerfect;
    int height;
    int size;

    Pair(boolean isPerfect,int height,int size){
        this.isPerfect=isPerfect;
        this.height=height;
        this.size=size;
    }
}; 
class Solution {
    PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> a - b);
    private Pair solve(TreeNode root,int k){
        if(root==null) return new Pair(true,0,0);

        Pair left=solve(root.left,k);
        Pair right=solve(root.right,k);

        if(left.isPerfect && right.isPerfect && left.height==right.height){
            int size=left.size+right.size+1;
            pq.offer(size);
            if(pq.size()>k) pq.poll();

            return new Pair(true,left.height+1,size);
        }
        return new Pair(false,Math.min(left.height,right.height)+1,left.size+right.size+1);
    }
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        solve(root,k);
        if(pq.size()<k) return -1;
        return pq.peek();
    }
}