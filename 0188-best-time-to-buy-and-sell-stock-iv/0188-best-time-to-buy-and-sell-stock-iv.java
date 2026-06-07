class Solution {
    public int maxProfit(int k, int[] p) {
        int n=p.length;
        int[][] prev=new int[2][k+1];
        for(int ind=n-1;ind>=0;ind--){
            int[][] curr=new int[2][k+1];
            for(int buy=0;buy<2;buy++){
                for(int rt=1;rt<k+1;rt++){
                    if(buy==1){
                        int w1=p[ind]+prev[0][rt-1];
                        int w2=prev[1][rt];
                        curr[buy][rt]=Math.max(w1,w2);
                    }
                    else{
                        int w1=-p[ind]+prev[1][rt];
                        int w2=prev[0][rt];
                        curr[buy][rt]=Math.max(w1,w2);
                    }
                }
            }
            prev=curr;
        }
        return prev[0][k];
    }
}