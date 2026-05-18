package TBankContest2026Spring;

import java.util.Scanner;

public class Program4 {

    public static int maxProfit(int[] prices) {
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] prices = new int[n];

        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(split[i]);
        }

        System.out.println(maxProfit(prices));
    }
}
