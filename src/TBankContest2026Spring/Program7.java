package TBankContest2026Spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//public class Program7 {
//
//    public static long minCoins(int n, long x, long[] coins) {
//        Map<Long, Long>[] memo = new HashMap[n];
//        for (int i = 0; i < n; i++) {
//            memo[i] = new HashMap<>();
//        }
//        return dp(memo, coins, n, 0, x);
//    }
//
//    private static long dp(Map<Long, Long>[] memo, long[] coins, int n, int idx, long rem) {
//        if (idx == n - 1) {
//            return rem;
//        }
//
//        if (memo[idx].containsKey(rem)) {
//            return memo[idx].get(rem);
//        }
//
//        long nextCoin = coins[idx + 1];
//        long currentCoin = coins[idx];
//        long k = nextCoin / currentCoin;
//
//        long countInside = rem % k;
//
//        long res = countInside + dp(memo, coins, n,idx + 1, rem / k);
//
//        if (countInside != 0) {
//            long resWithChange = (k - countInside) + dp(memo, coins, n,idx + 1, rem / k + 1);
//            res = Math.min(res, resWithChange);
//        }
//
//        memo[idx].put(rem, res);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String[] split = sc.nextLine().split(" ");
//        int n = Integer.parseInt(split[0]);
//        long x = Long.parseLong(split[1]);
//
//        split = sc.nextLine().split(" ");
//        long[] coins = new long[n];
//        for (int i = 0; i < n; i++) {
//            coins[i] = Long.parseLong(split[i]);
//        }
//
//        System.out.println(minCoins(n, x, coins));
//    }
//}


public class Program7 {

    private static long minCoins(long[] coins, int n, int i, long x) {
        if (i == n - 1) return x;

        long next = coins[i + 1];
        long cur = coins[i];
        long k = next / cur;

        long count = x % k;

        long res = count + minCoins(coins, n, i + 1, x / k);

        if (count != 0) {
            long change = (k - count) + minCoins(coins, n, i + 1, x / k + 1);

            if (change < res) {
                res = change;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        long x = Long.parseLong(split[1]);

        split = sc.nextLine().split(" ");
        long[] coins = new long[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Long.parseLong(split[i]);
        }

        System.out.println(minCoins(coins, n, 0, x));
    }
}
