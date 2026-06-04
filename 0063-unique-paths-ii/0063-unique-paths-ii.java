class Solution {
    public int uniquePathsWithObstacles(int[][] obs) {
        int m=obs.length;
        int n=obs[0].length;

        if(obs[0][0]==1 || obs[m-1][n-1]==1) return 0;
    
        int[] prev=new int[n];
        boolean isObs=false;
        for(int j=0;j<n;j++){
            if(isObs==false) prev[j]=1;
            if(obs[0][j]==1 || isObs==true){
                prev[j]=0;
                isObs=true;
            }
        }
        for(int i=1;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                if(obs[i][j]==1) curr[j]=0;
                else{
                    if(j==0) curr[j]=prev[j];
                    else curr[j]=prev[j]+curr[j-1];
                }
            }
            prev=curr;
        }
        return prev[n-1];
    }
}