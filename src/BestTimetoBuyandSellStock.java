public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int sell = 0;
        int bestBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < bestBuy) {
                bestBuy = prices[i];
            } else {
                if (prices[i] - bestBuy > sell) {
                    sell = prices[i] - bestBuy;
                }
            }
        }
        return sell;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
