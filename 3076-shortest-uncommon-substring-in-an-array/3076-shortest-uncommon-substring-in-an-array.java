class Node{
    Node[] links=new Node[26];
    int count=0;
    int lastVisInd=-1;
    
    Node(){}
};
class Solution {
    private Node root=new Node();
    private void insert(String word,int index){
        Node node=root;
        for(char ch: word.toCharArray()){
            if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
            }
            node=node.links[ch-'a'];
            if(node.lastVisInd!=index){
                node.count++;
                node.lastVisInd=index;
            }
        }
        return;
    }
    private boolean isValid(String word){
         Node node=root;
         for(char ch: word.toCharArray()){
            node=node.links[ch-'a'];
        }
        return node.count==1;
    }
    public String[] shortestSubstrings(String[] arr) {
        int n=arr.length;
        for(int index=0;index<n;index++){
            String curr=arr[index];
            int len=curr.length();
            HashSet<String> st=new HashSet<>();
            for(int start=0;start<len;start++){
                for(int end=start;end<len;end++){
                    String sub=curr.substring(start,end+1);
                    if(st.contains(sub)) continue;
                    insert(sub,index);
                    st.add(sub);
                }
            }
        }
        String[] answer=new String[n];
        for(int index=0;index<n;index++){
             String best="";
             String curr=arr[index];
             int len=curr.length();
             for(int start=0;start<len;start++){
                for(int end=start;end<len;end++){
                    String sub=curr.substring(start,end+1);
                    if(isValid(sub)){
                        if(best.equals("") || sub.length()<best.length() || (sub.length()==best.length() && sub.compareTo(best)<0)){
                            best=sub;
                        }
                        break;
                    }
                }
     
             }
             answer[index]=best;
        }
        return answer;
    }
}