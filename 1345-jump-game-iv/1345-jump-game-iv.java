class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
};
class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        int[] jumps=new int[n];
        for(int i=0;i<n;i++) jumps[i]=1000000000;
        HashMap<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.putIfAbsent(arr[i],new ArrayList<>());
            mp.get(arr[i]).add(i);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.first - b.first);
        pq.offer(new Pair(0,0));
        jumps[0]=0;

        while(!pq.isEmpty()){
             Pair tp=pq.poll();
             int currInd=tp.second;
             int currJumps=tp.first;

             if(currInd==n-1) return currJumps;
             if(jumps[currInd]<currJumps) continue;

             if(currInd+1<n && jumps[currInd+1]>1+currJumps){
                jumps[currInd+1]=1+currJumps;
                pq.offer(new Pair(jumps[currInd+1],currInd+1));
             }
             if(currInd-1>=0 && jumps[currInd-1]>1+currJumps){
                jumps[currInd-1]=1+currJumps;
                pq.offer(new Pair(jumps[currInd-1],currInd-1));
             }
             List<Integer> list=mp.get(arr[currInd]);
             if(list==null) continue;
             for(int j: mp.get(arr[currInd])){
                if(j==currInd) continue;
                if(jumps[j]>1+currJumps){
                    jumps[j]=1+currJumps;
                    pq.offer(new Pair(jumps[j],j));
                }
             }
             mp.remove(arr[currInd]);
        }
        return -1;
    }
}