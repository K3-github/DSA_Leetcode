class Node{
    Node[] links=new Node[26];
    int count=0;
    int lastVisited=-1;
    Node(){}
}
class Solution{
    private Node root=new Node();
    private void insert(String word,int idx){
        Node node=root;
        for(char ch:word.toCharArray()){
            if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
            }
            node=node.links[ch-'a'];
            if(node.lastVisited!=idx){
                node.count++;
                node.lastVisited=idx;
            }
        }
    }
    private boolean isValid(String word){
        Node node=root;
        for(char ch:word.toCharArray()){
            node=node.links[ch-'a'];
        }
        return node.count==1;
    }
    public String[] shortestSubstrings(String[] arr){
        int n=arr.length;
        for(int idx=0;idx<n;idx++){
            HashSet<String> set=new HashSet<>();
            String str=arr[idx];
            for(int i=0;i<str.length();i++){
                for(int j=i;j<str.length();j++){
                    set.add(str.substring(i,j+1));
                }
            }
            for(String s:set){
                insert(s,idx);
            }
        }
        String[] ans=new String[n];
        for(int idx=0;idx<n;idx++){
            String res="";
            for(int len=1;len<=arr[idx].length();len++){
                for(int i=0;i+len<=arr[idx].length();i++){
                    String sub=arr[idx].substring(i,i+len);
                    if(isValid(sub)){
                        if(res.equals("")||sub.compareTo(res)<0){
                            res=sub;
                        }
                    }
                }
                if(!res.equals("")){
                    break;
                }
            }
            ans[idx]=res;
        }
        return ans;
    }
}