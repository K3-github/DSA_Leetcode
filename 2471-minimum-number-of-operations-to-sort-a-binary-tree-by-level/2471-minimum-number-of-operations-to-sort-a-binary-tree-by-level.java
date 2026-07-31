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
    private int findMinOps(int[] level,HashMap<Integer,Integer> index){
        int[] temp= level.clone();;
        Arrays.sort(temp);
        int ops=0;
        for (int i = 0; i < level.length; i++) {
            if (level[i] == temp[i]) continue;
            int idx = index.get(temp[i]);
            int currVal = level[i];
            int targetVal = level[idx];
            level[i] = targetVal;
            level[idx] = currVal;
            index.put(currVal, idx);
            index.put(targetVal, i);

           ops++;
        }
        return ops;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            HashMap<Integer,Integer> index=new HashMap<>();
            int[] level=new int[size];
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                level[i]=node.val;
                index.put(node.val,i);

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            ans+=findMinOps(level,index);
        }
        return ans;
    }
}



