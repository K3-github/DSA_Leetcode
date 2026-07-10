class Solution {
    private boolean solve(int[] start, int mid, int d) {
        long prev = start[0];
        for(int i = 1; i < start.length; i++) {
            long curr = Math.max((long)start[i], prev + mid);
            if(curr > (long)start[i] + d) return false;
            prev = curr;
        }
        return true;
}
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n=start.length;
        int low=0;
        int high = start[n-1] + d - start[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve(start,mid,d)==true){
                low=mid+1;
            }
            else high=mid-1;
        }
        return high;
    }
}