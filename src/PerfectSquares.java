import java.util.HashMap;

public class PerfectSquares {

//    public static int numSquares(int n) {
//        int a = 1;
//        while (a * a < n) {
//            a++;
//        }
//        a--;
//
//        int sqr = a * a;
//        while (n > 0) {
//            if (n >= sqr) {
//                System.out.println(sqr);
//                n -= sqr;
//            } else {
//                a--;
//                sqr = a * a;
//            }
////            if (n - sqr >= (a - 1) * (a - 1)) {
////
////            } else {
////
////            }
//        }
//
//        return n;
//    }


//    это я пытался решить без знаний DP
//    конечно и щас DP нихуя не знаю, но все же уже вижу паттерн как можно забрутфорсить рекурсией

//    private static int rec(int n, int a, int k) {
//        if (n < 0) return Integer.MAX_VALUE;
//        if (n == 0) return k;
//        int ans = Integer.MAX_VALUE;
//        if (a * a <= n)
//             ans = rec(n , a + 1, k);
//        return Math.min(rec(n  - a * a, a, k + 1), ans);
//    }
//
//    public static int numSquares(int n) {
//        return rec(n, 1, 0);
//    }

//    ожидаемое TLE на n=296

//    private static int rec(int n, HashMap<Integer, Integer> map, HashMap<Integer, Integer> squares, int k) {
//        if (n < 0) return Integer.MAX_VALUE;
//
//        if (n == 0) return k;
//
//        if (map.containsKey(n) && map.get(n) <= k) return map.get(n);
//
//        int a = 1;
//        while (n - squares.get(a) >= 0) {
//            a++;
//        }
//        a--;
//
//        int ans = Integer.MAX_VALUE;
//        while (a > 0) {
//            ans = Math.min(ans, rec(n - squares.get(a), map, squares, k + 1));
//            a--;
//        }
//
//        map.put(n, ans);
//
//        return ans;
//    }
//
//    private static HashMap<Integer, Integer> makeSquares() {
//        HashMap<Integer, Integer> squares = new HashMap<>();
//        for (int i = 1; i < 100; i++) {
//            squares.put(i, i * i);
//        }
//        return squares;
//    }
//
//    public static int numSquares(int n) {
//        return rec(n, new HashMap<>(), makeSquares(), 0);
//    }

//    поменял, но всё равно TLE при n = 7168 (502/589)
//    чуть изменил все равно TLE n = 5756

//    private static int rec(int n, HashMap<Integer, Integer> map, HashMap<Integer, Integer> squares) {
//        if (n < 0) return Integer.MAX_VALUE;
//
//        if (map.containsKey(n)) return map.get(n);
//
//        int a = 1;
//        while (n - squares.get(a) >= 0) {
//            a++;
//        }
//        a--;
//
//        int ans = Integer.MAX_VALUE;
//        while (a > 0) {
//            ans = Math.min(ans, 1 + rec(n - squares.get(a), map, squares));
//            a--;
//        }
//
//        map.put(n, ans);
//
//        return ans;
//    }
//
//    private static HashMap<Integer, Integer> makeSquares() {
//        HashMap<Integer, Integer> squares = new HashMap<>();
//        for (int i = 1; i < 101; i++) {
//            squares.put(i, i * i);
//        }
//        return squares;
//    }
//
//    public static int numSquares(int n) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 1; i < 101; i++) {
//            map.put(i * i, 1);
//        }
//        return rec(n, map, makeSquares());
//    }


//    beats 5% memory 10%
//    пиздец. еле еле душа в теле эта хуетень прошла нахуй

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;

            int a = (int) Math.round(Math.sqrt(i));
            for (int j = a; j > 0; j--) {
                if (i - j * j >= 0)
                    dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

//    beats 55% memory 39% runtime 35ms
//    я его рот ебал нахуй. только с подсмотров в ответы смог сделать dp

    public static void main(String[] args) {
        System.out.println(numSquares(3));
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(9));
//        System.out.println(numSquares(296));
//        System.out.println(numSquares(225));
//        System.out.println(numSquares(50));
//        System.out.println(numSquares(297));
//        System.out.println(numSquares(48));
//        System.out.println(numSquares(7168));
        System.out.println(numSquares(5756));
        System.out.println(numSquares(10000));
    }
}
