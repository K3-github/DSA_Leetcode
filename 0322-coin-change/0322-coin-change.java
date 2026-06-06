class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        Arrays.fill(prev,10000000);
        prev[0]=0;
        for(int amt=1;amt<=amount;amt++){
            if(coins[0]<=amt){
                if(amt%coins[0]==0) prev[amt]=amt/coins[0];
            }
        }
        for(int ind=1;ind<n;ind++){
            int[] curr=new int[amount+1];
            curr[0]=0;
            for(int amt=1;amt<=amount;amt++){
                int w1=10000000;
                if(coins[ind]<=amt){
                    w1=1+curr[amt-coins[ind]];
                }
                int w2=prev[amt];
                curr[amt]=Math.min(w1,w2);
            }
            prev=curr;
        }
        int ans=prev[amount];
        if(ans==10000000) return -1;
        return ans;
    }
}