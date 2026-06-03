class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        Pair p=(Pair)o;
        return first==p.first && second==p.second;
    }

    @Override
    public int hashCode(){
        return Objects.hash(first,second);
    }
}

class Solution{
    public int maximalNetworkRank(int n,int[][] roads){

        int[] ind=new int[n];
        HashMap<Pair,Integer> mp=new HashMap<>();
        for(int[] r:roads){
            int u=Math.min(r[0],r[1]);
            int v=Math.max(r[0],r[1]);
            ind[u]++;
            ind[v]++;
            Pair p=new Pair(u,v);
            mp.put(p,1);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rank=ind[i]+ind[j];
                Pair p=new Pair(i,j);
                if(mp.containsKey(p)){
                    rank--;
                }
                ans=Math.max(ans,rank);
            }
        }

        return ans;
    }
}