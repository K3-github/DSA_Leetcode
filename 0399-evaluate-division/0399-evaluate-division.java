class Pair{
    String node;
    double val;

    Pair(String node,double val){
        this.node=node;
        this.val=val;
    }
};
class Solution {
    private double solve(String node,String target,HashMap<String,List<Pair>> graph,HashMap<String,Boolean> vis){
        if(node.equals(target)) return 1.00000;
        vis.put(node,true);
        

        for(Pair p: graph.get(node)){
            String adjNode=p.node;
            double val=p.val;
            if(!vis.containsKey(adjNode)){
                double res=solve(adjNode,target,graph,vis);
                if(res != -1.00000) return val * res;
            }
        }
        return -1.00000;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> graph=new HashMap<>();
        int n=equations.size();
        for(int i=0;i<n;i++){
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            List<Pair> ls=graph.get(u);
            if(ls==null){
                graph.put(u,new ArrayList<>());
            }
            graph.get(u).add(new Pair(v,values[i]));

            List<Pair> dls=graph.get(v);
            if(dls==null){
                graph.put(v,new ArrayList<>());
            }
            graph.get(v).add(new Pair(u,1.00000/values[i]));
        }
        double[] ans=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            HashMap<String,Boolean> vis=new HashMap<>();
            String src=queries.get(i).get(0);
            String target=queries.get(i).get(1);
            if(!graph.containsKey(src) || !graph.containsKey(target)) ans[i]=-1.00000;
            else if(src.equals(target)) ans[i]=1.00000;
            else ans[i]=solve(src,target,graph,vis);
        }
        return ans;
    }
}