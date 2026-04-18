class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minbuy = prices[0];

        for(int sell : prices) {
            maxP = Math.max(maxP, sell - minbuy);
            minbuy = Math.min(minbuy, sell);
        }
        return maxP;
    }
}
