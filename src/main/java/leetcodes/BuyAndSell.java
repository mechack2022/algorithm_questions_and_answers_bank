package leetcodes;

/*
Best Time to Buy and Sell Stock:
   - Statement: Given an array `prices` where `prices[i]` is the price of a given stock on day `i`, find the maximum profit that can be achieved by buying and selling the stock.
   - Example 1: Input: prices = [7, 1, 5, 3, 6, 4], Output: 5 (buy at day 2 and sell at day 5).
   - Example 2: Input: prices = [7, 6, 4, 3, 1], Output: 0 (no transactions are possible, so the maximum profit is 0).

   Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
*/
public class BuyAndSell {

    public static void main(String[] args) {
        System.out.println(buyAndSell1(new int[]{7, 1, 5, 3, 6, 4}));

     System.out.println(

    bestTimeToBuyStock(new int[] {
        7, 1, 5, 3, 6, 4
    }));
        System.out.println(

    bestTimeToBuyStock(new int[] {
        7, 6, 4, 3, 1
    }));
}
    public static int buyAndSell1(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }

            }
        }
        return maxProfit;
    }

    public static int bestTimeToBuyStock(int[] stockPrices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : stockPrices) {
            // Update the minimum price seen so far
            minPrice = Math.min(minPrice, price);

            // Update the maximum profit if the current price provides a better selling opportunity
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;

    }

}
