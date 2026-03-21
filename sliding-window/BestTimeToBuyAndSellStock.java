// Problem  : Best Time to Buy and Sell Stock
// Link     : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
// Difficulty: Easy
// Pattern  : Sliding Window
// Time     : O(n) | Space: O(1)

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}