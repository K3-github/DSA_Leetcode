class Pair{
    double first;
    int second;

    Pair(double first,int second){
       this.first=first;
       this.second=second;
    }
};
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(new Pair(succProb[i],edges[i][1]));
            graph.get(edges[i][1]).add(new Pair(succProb[i],edges[i][0]));
        }
        double[] prob=new double[n];
        for(int i=0;i<n;i++){
            prob[i]=0.00;
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)-> Double.compare(b.first,a.first));
        q.offer(new Pair(1.00,start_node));
        prob[start_node]=1.00;

        while(!q.isEmpty()){
            Pair tp=q.poll();
            int currNode=tp.second;
            double currProb=tp.first;
            if(currNode==end_node) return currProb;
            if(currProb<prob[currNode]) continue;

            for(Pair p: graph.get(currNode)){
                int adjNode=p.second;
                double reqProb=p.first;

                if((currProb*reqProb)>prob[adjNode]){
                    prob[adjNode]=currProb*reqProb;
                    q.offer(new Pair(prob[adjNode],adjNode));
                }
            }
        }

        if(prob[end_node]==1.00) return 0.00;
        return prob[end_node];
    }
}