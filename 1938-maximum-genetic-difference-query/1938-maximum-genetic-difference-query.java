class Pair{
    int val;
    int ind;

    Pair(int val,int ind){
        this.val=val;
        this.ind=ind;
    }
};
class Node{
    Node[] links=new Node[2];
    int count=0;

    Node(){}
};
class Solution {
    private Node root=new Node();
    private int[] ans;
    HashMap<Integer,List<Integer>> tmp=new HashMap<>();
    HashMap<Integer,List<Pair>> qmp=new HashMap<>();
    private void insert(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(node.links[bit]==null){
                node.links[bit]=new Node();
            }
            node=node.links[bit];
            node.count++;
        }
    }
    private int getMax(int val){
        Node node=root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit=(val>>i)&1;
            if(node.links[1-bit]!=null && node.links[1-bit].count>0){
                ans=ans | (1<<i);
                node=node.links[1-bit];
            }
            else node=node.links[bit];
        }
        return ans;
    }
    private void remove(int num){
        Node node=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            node=node.links[bit];
            node.count--;
        }
    }
    public void solve(int node){
        if(!tmp.containsKey(node)) return;

        insert(node);
        if(qmp.containsKey(node)){
            List<Pair> list=qmp.get(node);
            for(int i=0;i<list.size();i++){
                Pair p=list.get(i);
                int val=p.val;
                int ind=p.ind;
                int getMaxXor=getMax(val);
                ans[ind]=getMaxXor;
            }
        }
        for(int child: tmp.get(node)){
            solve(child);
        }
        remove(node);
    }
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n=queries.length;
        ans=new int[n];
        for(int i=0;i<n;i++){
            int node=queries[i][0];
            int val=queries[i][1];
            List<Pair> list=qmp.get(node);
            if(list==null){
                qmp.put(node,new ArrayList<>());
            }
            qmp.get(node).add(new Pair(val,i));
        }
        for(int i=0;i<parents.length;i++){
            if(!tmp.containsKey(i)){
                tmp.put(i,new ArrayList<>());
            }
            List<Integer> list=tmp.get(parents[i]);
            if(list==null){
                tmp.put(parents[i],new ArrayList<>());
            }
            tmp.get(parents[i]).add(i);
        }
        int root=tmp.get(-1).get(0);
        solve(root);
        return ans;
    }
}