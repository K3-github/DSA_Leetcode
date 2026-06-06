class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        Arrays.fill(prev,0);
        prev[0]=1;
        for(int amt=1;amt<=amount;amt++){
            if((coins[0]<=amt) && (amt%coins[0]==0)){
                 prev[amt]=1;
            }
        }
        for(int ind=1;ind<n;ind++){
            int[] curr=new int[amount+1];
            curr[0]=1;
            for(int amt=1;amt<=amount;amt++){
                int w1=0;
                if(coins[ind]<=amt){
                    w1=curr[amt-coins[ind]];
                }
                int w2=prev[amt];
                curr[amt]=w1+w2;
            }
            prev=curr;
        }
        return prev[amount];
    }
}