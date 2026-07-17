class Solution {
    private int bsearch(int[][] v,int x){
        int low=0,high=v.length-1;
        while(low<=high){
            int mid=(low+high) >> 1;
            if(v[mid][0]>=x) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public int[] findRightInterval(int[][] intervals) {
        int n=intervals.length;
        int[][] v=new int[n][2];
        for(int i=0;i<n;i++){
            v[i]=new int[]{intervals[i][0],i};
        }
        Arrays.sort(v,(a,b)-> a[0] - b[0]);
        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            int end=intervals[i][1];
            int ind=bsearch(v,end);
            if(ind==n) answer[i]=-1;
            else answer[i]=v[ind][1];
        }
        return answer;
    }
}