class Solution {
    public int maximumWidth(int[] planks) {
        int n=planks.length;
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<n;i++){
            freq.put(planks[i],freq.getOrDefault(planks[i],0)+1);
        }
        List<Integer> v=new ArrayList<>();
        int ans=0;
        for(Map.Entry<Integer,Integer> e: freq.entrySet()){
            v.add(e.getKey());
            ans=Math.max(ans,e.getValue());
        }
        HashMap<Integer,Integer> pars=new HashMap<>();
        int m=v.size();
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                int e1=v.get(i),e2=v.get(j);
                int sum=e1+e2;
                if(i==j){
                    int f=freq.get(e1);
                    pars.put(sum,pars.getOrDefault(sum,0)+f/2);
                }
                else{
                    int mn=Math.min(freq.get(e1),freq.get(e2));
                    pars.put(sum,pars.getOrDefault(sum,0)+mn);
                }
            }
        }
        for(Map.Entry<Integer,Integer> e: pars.entrySet()){
            int f=freq.getOrDefault(e.getKey(),0);
            ans = Math.max(ans, e.getValue()+f);
        }
        return ans;
    }
}