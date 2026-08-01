/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public String serialize(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node!=null){
                sb.append(String.valueOf(node.val));
                sb.append(',');
                q.offer(node.left);
                q.offer(node.right);
            }
            else{
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        if(arr.length==1) return null;
        Queue<TreeNode> q=new LinkedList<>();
        int index=0;
        TreeNode root=new TreeNode(Integer.parseInt(arr[index++]));
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(arr[index].equals("#")) node.left=null;
            else{
                node.left=new TreeNode(Integer.parseInt(arr[index]));
                q.offer(node.left);
            }
            index++;
            if(arr[index].equals("#")) node.right=null;
            else{
                node.right=new TreeNode(Integer.parseInt(arr[index]));
                q.offer(node.right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;