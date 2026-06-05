class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n=mat.length;
        int[] prev=new int[n];
        for(int j=0;j<n;j++){
            prev[j]=mat[0][j];
        }
        for(int i=1;i<n;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                int left=10000000,right=10000000;
                if(j>0) left=prev[j-1];
                if(j<n-1) right=prev[j+1];
                int up=prev[j];
                curr[j]=mat[i][j]+Math.min(left,Math.min(up,right));
            }
            prev=curr;
        }
        int ans=10000000;
        for(int j=0;j<n;j++){
            ans=Math.min(ans,prev[j]);
        }
        return ans;
    }
}