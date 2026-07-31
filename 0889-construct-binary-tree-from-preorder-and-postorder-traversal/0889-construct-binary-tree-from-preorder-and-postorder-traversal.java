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
    HashMap<Integer,Integer> mp=new HashMap<>();
    private TreeNode build(int[] pre,int st1,int en1,int[] post,int st2,int en2){
        if(st1>en1) return null;

        int rootVal=pre[st1];
        TreeNode root=new TreeNode(rootVal);
        if(st1==en1) return root;
        int leftInd=mp.get(pre[st1+1]);
        int leftEle=leftInd-st2+1;
        root.left=build(pre,st1+1,st1+leftEle,post,st2,leftInd);
        root.right=build(pre,st1+leftEle+1,en1,post,leftInd+1,en2-1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0;i<postorder.length;i++){
            mp.put(postorder[i],i);
        }
        return build(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
}