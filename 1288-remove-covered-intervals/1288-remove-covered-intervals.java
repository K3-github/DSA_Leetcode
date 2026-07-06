class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count=0;
        int n=intervals.length;
        int[] removed=new int[n];
        for(int i=0;i<n;i++){
            if(removed[i]==1) continue;
            int start=intervals[i][0];
            int end=intervals[i][1];
            for(int j=0;j<n;j++){
                 if(i==j) continue;
                 if(start>=intervals[j][0] && end<=intervals[j][1]){
                    removed[i]=1;
                 }
            }
        }
        for(int i=0;i<n;i++){
            if(removed[i]==0) count++;
        }
        return count;
    }
}

