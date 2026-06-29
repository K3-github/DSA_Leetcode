class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        List<int[]> cells=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cells.add(new int[]{mat[i][j],i,j});
            }
        }
        Collections.sort(cells,(a,b)->a[0]-b[0]);
        int[] rowMax=new int[n];
        int[] colMax=new int[m];
        int ans=0;
        int idx=0;
        while(idx<cells.size()){
            int val=cells.get(idx)[0];
            List<int[]> same=new ArrayList<>();
            while(idx<cells.size() && cells.get(idx)[0]==val){
                same.add(cells.get(idx));
                idx++;
            }
            int[] curr=new int[same.size()];
            for(int k=0;k<same.size();k++){
                int r=same.get(k)[1];
                int c=same.get(k)[2];
                curr[k]=1+Math.max(rowMax[r],colMax[c]);
                ans=Math.max(ans,curr[k]);
            }
            for(int k=0;k<same.size();k++){
                int r=same.get(k)[1];
                int c=same.get(k)[2];
                rowMax[r]=Math.max(rowMax[r],curr[k]);
                colMax[c]=Math.max(colMax[c],curr[k]);
            }
        }

        return ans;
    }
}