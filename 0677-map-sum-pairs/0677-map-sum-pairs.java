class Node{
    Node[] links=new Node[26];
    int sum=0;

    Node(){}
};
class MapSum {
    private Node root;
    HashMap<String,Integer> mp;
    public MapSum() {
        root=new Node();
        mp=new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int newVal=val-mp.getOrDefault(key,0);
        mp.put(key,val);
        Node node=root;
        for(char ch: key.toCharArray()){
            if(node.links[ch-'a']==null){
                node.links[ch-'a']=new Node();
            }
            node=node.links[ch-'a'];
            node.sum+=newVal;
        }
        return;
    }
    
    public int sum(String prefix) {
        Node node=root;
        for(char ch: prefix.toCharArray()){
            node=node.links[ch-'a'];
            if(node==null) return 0;
        }
        return node.sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */