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
    private void pushLeft(TreeNode root, Stack<TreeNode> st){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();

        pushLeft(root1,st1);
        pushLeft(root2,st2);

        List<Integer> ans=new ArrayList<>();
        while(!st1.isEmpty() || !st2.isEmpty()){
            Stack<TreeNode> curr;

            if(st1.isEmpty()){
                curr=st2;
            }
            else if(st2.isEmpty()){
                curr=st1;
            }
            else if(st1.peek().val<=st2.peek().val){
                curr=st1;
            }
            else curr=st2;

            TreeNode node=curr.pop();
            ans.add(node.val);

            pushLeft(node.right,curr);
        }
        return ans;
    }
}