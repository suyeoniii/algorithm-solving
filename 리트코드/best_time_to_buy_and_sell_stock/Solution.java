class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i<prices.length; i++){
            if (minPrice < prices[i]) {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            } else {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}