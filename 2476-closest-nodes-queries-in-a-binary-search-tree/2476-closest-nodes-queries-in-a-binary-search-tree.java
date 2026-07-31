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
    int largestValue;
    int smallestValue;
    List<Integer> arr=new ArrayList<>();
    private void searchLargest(List<Integer> arr,int val){
       int low=0,high=arr.size()-1;

       while(low<=high){
          int mid=(low+high) >> 1;
          if(arr.get(mid)<=val){
            largestValue=arr.get(mid);
            low=mid+1;
          }
          else high=mid-1;
       }
    }
    private void searchSmallest(List<Integer> arr,int val){
       int low=0,high=arr.size()-1;

       while(low<=high){
          int mid=(low+high) >> 1;
          if(arr.get(mid)>=val){
            smallestValue=arr.get(mid);
            high=mid-1;
          }
          else low=mid+1;
       }
    }
    private void trav(TreeNode root){
        if(root==null) return;
        trav(root.left);
        arr.add(root.val);
        trav(root.right);
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        trav(root);
        List<List<Integer>> ans=new ArrayList<>();
        for(Integer val: queries){
            largestValue=-1;smallestValue=-1;
            searchLargest(arr,val);
            searchSmallest(arr,val);
            ans.add(List.of(largestValue,smallestValue));
        }
        return ans;
    }
}