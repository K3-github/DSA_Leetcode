class TopVotedCandidate {
    int[][] v;
    public TopVotedCandidate(int[] persons, int[] times) {
        int n=persons.length;
        v=new int[n][2];
        int[] pv=new int[5000];
        int mxVotes=0,winPerson=-1;
        for(int i=0;i<n;i++){
            int time=times[i];
            int p=persons[i];
            pv[p]++;
            if(mxVotes<=pv[p]){
                mxVotes=pv[p];
                winPerson=p;
            }
            v[i]=new int[]{time,winPerson};
        }
    }
    
    public int q(int t) {
        int low=0,high=v.length-1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(v[mid][0]>t) high=mid-1;
            else low=mid+1;
        }
        return v[high][1];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */