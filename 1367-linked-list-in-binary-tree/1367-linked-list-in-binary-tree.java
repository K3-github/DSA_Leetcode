/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private boolean check(TreeNode root,ListNode head){
        if(head==null) return true;
        if(root==null || root.val!=head.val) return false;

        boolean left=check(root.left,head.next);
        boolean right=check(root.right,head.next);
        return (left==true || right==true) ? true : false;
    }
    private boolean solve(TreeNode root,ListNode head){
        if(root==null) return false;

        if(root.val==head.val){
            if(check(root,head)==true) return true;
        }
        boolean left=solve(root.left,head);
        boolean right=solve(root.right,head);
        return (left==true || right==true) ? true : false;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return solve(root,head);
    }
}