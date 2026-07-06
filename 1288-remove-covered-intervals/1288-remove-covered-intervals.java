class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count=0;
        int n=intervals.length;
        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0], b[0]);
        });
        for(int i=0;i<n;i++){
            int end=intervals[i][1];
            while(i<n-1 && end>=intervals[i+1][1]){
                i++;
                count++;
            }
        }
        return n-count;
    }
}

// 1 10.  3 7. 4 9. 7 13
// 1,4   2,8   3,6
// 1,4 1,2 3,4??


