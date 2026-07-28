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
    int id=1;
    List<TreeNode> ans=new ArrayList<>();
    HashMap<Integer,Integer> freq=new HashMap<>();
    HashMap<String,Integer> ids=new HashMap<>();
    private int solve(TreeNode root){
        if(root==null) return 0;

        int leftId=solve(root.left);
        int rightId=solve(root.right);

        String key=root.val + "," + leftId + "," + rightId;
        if(!ids.containsKey(key)){
            ids.put(key,id++);
        }

        int currId=ids.get(key);
        freq.put(currId,freq.getOrDefault(currId,0)+1);
        if(freq.get(currId)==2){
            ans.add(root);
        }
        return currId;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return ans;
    }
}