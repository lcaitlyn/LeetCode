public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }

        return res;
    }

//    runtime 0ms beats 100% memory 97.7%
}
