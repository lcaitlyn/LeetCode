import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CoinChange {

//    private static int rec(int[] coins, int amount, int index, int total) {
//        if (index == coins.length) return Integer.MIN_VALUE;
//        if (total > amount) return Integer.MIN_VALUE;
//        if (total == amount) return 0;
//        int take = 1 + rec(coins, amount, index, total + coins[index]);
//        int notTake = rec(coins, amount, index + 1, total);
//        if (take < 0 && notTake < 0) return Integer.MIN_VALUE;
//        if (take < 0) return notTake;
//        if (notTake < 0) return take;
//        return Math.min(take, notTake);
//    }
//
//    public static int coinChange(int[] coins, int amount) {
//        int res = rec(coins, amount, 0, 0);
//        return (res < 0) ? -1 : res;
//    }

//    так ну ожидаемое нах TLE
//    coins = [411,412,413,414,415,416,417,418,419,420,421,422]
//    amount = 9864

//    итак что теперь придумать, а точнее как применить DP здесь?
//    давай подумаем
//    стоит ли сортировать монеты? думаю нет
//    как решить за O(n) да?
//    хотя думаю отсортировать стоит
//    только в обрятном порядке
//    по сути нам нужно брать сперва самые дорогие монетки, и умнжать их
//    почему самые дорогие? потому что они дадут самый наименщий результат
//    нужно вспомнить что-то по тиу perfectSquares задачки

//    опа, а вот тут я нашел кое-что по интереснее
//    возможно можно пройтись по всем n = amount и собирать самые минимальные числа
//    но монетки все равно должны быть отсортированы в порядке убивания, чтобы мы брали сперва самую большую



    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) dp[i] = -1;
        }
        return dp[amount];
    }

//    beats 39.57% memory 6.47% runtime 18ms
//    пиздец я сам решил это нахуй (ну чуть глянул в perfectSquares)

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
