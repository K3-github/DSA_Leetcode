class Node{
    Node[] links=new Node[26];
    boolean end=false;

    Node(){}
};
class Solution {
    private Node root=new Node();
    List<String> ans=new ArrayList<>();
    private void insert(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
            }
            node=node.links[ch-'a'];
        }
        node.end=true;
    }
    private void solve(int ind,List<String> curr,String s){
        if(ind==s.length()){
            String str=String.join(" ",curr);
            ans.add(str);
            return;
        }
        Node node=root;
        StringBuilder sub=new StringBuilder();
        for(int j=ind;j<s.length();j++){
            char ch=s.charAt(j);
            sub.append(ch);
            node=node.links[ch-'a'];
            if(node==null) break;
            if(node.end==true){
                curr.add(sub.toString());
                solve(j+1,curr,s);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String str: wordDict){
            insert(str);
        }
        List<String> curr=new ArrayList<>();
        solve(0,curr,s);
        return ans;
    }
}