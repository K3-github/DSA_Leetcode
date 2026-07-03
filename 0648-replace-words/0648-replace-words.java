class Node{
    Node[] links=new Node[26];
    boolean end=false;

    Node(){}
};
class Solution {
    private Node root=new Node();
    private void insert(String word){
        Node node=root;
        for(char ch: word.toCharArray()){
             if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
             }
             node=node.links[ch-'a'];
        }
        node.end=true;
        return;
    }
    private String getShortForm(String word){
        StringBuilder shortForm=new StringBuilder();
        Node node=root;
        for(char ch: word.toCharArray()){
             node=node.links[ch-'a'];
             if(node==null) return "";
             shortForm.append(ch);
             if(node.end==true) return shortForm.toString();
        }
        return shortForm.toString();
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        for(int i=0;i<dictionary.size();i++){
            insert(dictionary.get(i));
        }
        List<String> words = Arrays.asList(sentence.split(" "));
        for(int i=0;i<words.size();i++){
            String shortForm=getShortForm(words.get(i));
            if(shortForm=="") continue;
            words.set(i,shortForm);
        }
        return String.join(" ", words);
    }
}