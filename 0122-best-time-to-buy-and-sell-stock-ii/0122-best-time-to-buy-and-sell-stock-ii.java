class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int mn=prices[0];
        int ans=0;
        for(int i=0;i<n;i++){
            if(prices[i]>=mn){
                ans+=prices[i]-mn;
                mn=prices[i];
            }
            else{
                mn=Math.min(mn,prices[i]);
            }
        }
        return ans;
    }
}