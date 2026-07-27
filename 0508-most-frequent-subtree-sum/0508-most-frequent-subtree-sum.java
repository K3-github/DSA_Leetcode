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
    HashMap<Integer,Integer> freq=new HashMap<>();
    int mxFreq=0;
    private int solve(TreeNode root){
        if(root==null) return 0;

        int left=solve(root.left);
        int right=solve(root.right);

        int subTreeSum=root.val+left+right;
        freq.put(subTreeSum,freq.getOrDefault(subTreeSum,0)+1);
        mxFreq=Math.max(mxFreq,freq.get(subTreeSum));
        return subTreeSum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        solve(root);
        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e: freq.entrySet()){
             if(e.getValue()==mxFreq) ans.add(e.getKey());
        }
        int[] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
    }
}