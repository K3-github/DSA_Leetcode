class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];
        for(int j=0;j<n;j++){
            prev[j]=1;
        }
        for(int i=1;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                if(j==0) curr[j]=prev[j];
                else curr[j]=prev[j]+curr[j-1];
            }
            prev=curr;
        }
        return prev[n-1];
    }
}