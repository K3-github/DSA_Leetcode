class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int[][] arr=new int[n+1][2];
        for(int i=0;i<n;i++){
            arr[i]=intervals[i];
        }
        arr[n][0]=newInterval[0];
        arr[n][1]=newInterval[1];
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(arr, (a,b)-> a[0] - b[0]);
        for(int i=0;i<n+1;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            while(i<n && end>=arr[i+1][0]){
                end=Math.max(end,arr[i+1][1]);
                i++;
            }
            ans.add(new int[]{start,end});
        }
        return ans.toArray(new int[ans.size()][]);
    }
}