class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n=prices.length;
        int m=discounts.length;

        int i=n-1,j=m-1;
        double price=0;
        while(j>=0 || i>=0){
            if(j>=0 && i>=0){
                price+= (double)prices[i]*(100-discounts[j])/100*1.00000;
            }
            else if(i>=0){
                price+=prices[i];
            }
            j--;i--;
        }
        return price;
    }
}