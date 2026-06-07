class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int mn=prices[0];
        int ans=0;
        for(int i=1;i<n;i++){
            ans=Math.max(ans,prices[i]-mn);
            mn=Math.min(mn,prices[i]);
        }
        return ans;
    }
}