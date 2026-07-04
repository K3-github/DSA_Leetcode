class Node{
    Node[] links=new Node[10];
    Node(){}
};
class Solution {
    private Node root=new Node();
    private void insert(String num){
        Node node=root;
        for(char ch: num.toCharArray()){
            if(node.links[ch-'0']==null){
                node.links[ch-'0']=new Node();
            }
            node=node.links[ch-'0'];
        }
        return;
    }
    private int getLength(String num){
        Node node=root;
        int len=0;
        for(char ch: num.toCharArray()){
            if(node.links[ch-'0']==null) return len;
            node=node.links[ch-'0'];
            len++;
        }
        return len;
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        for(int i=0;i<arr2.length;i++){
            insert(String.valueOf(arr2[i]));
        }
        int ans=0;
        for(int i=0;i<arr1.length;i++){
            String str=String.valueOf(arr1[i]);
            ans=Math.max(ans,getLength(str));
        }
        return ans;
    }
}