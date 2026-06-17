class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a,b)-> a[1] - b[1]);
        int cnt=0;
        for(int i=0;i<n;i++){
             int end=intervals[i][1];
             while(i<n-1 && intervals[i+1][0]<end){
                i++; cnt++;
             }
        }
        return cnt;
    }
}