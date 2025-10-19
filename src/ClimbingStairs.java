public class ClimbingStairs {

//    private static int count(int cur, int n) {
//        if (cur > n) return 0;
//        if (cur == n) return 1;
////        int res = 0;
////        res += count(cur + 1, n);
////        res += count(cur + 2, n);
////        return res;
//      return count(cur + 1, n) + count(cur + 2, n);
//    }
//
//    public static int climbStairs(int n) {
//        return count(0, n);
//    }

//    вариант №1. вроде все четко, но на тесте n=44 TLE вышел
//    как оптимизировать? от чего отказаться в угоду скорости?


//    hint 1:
//    To reach nth step, what could have been your previous steps? (Think about the step sizes)

//    интересная подсказка. он предлагает что то постоянно тащить за собой
//    какое-то состояние

//    прикол в том что если мы будем ходить по 2 раза. мы всегда будем знать что это растояние пройти можно точно да
//    может быть считать к-во 2ных шагов которые мы можем сделать?

//    public static int climbStairs(int n) {
//        if (n < 0) return 0;
//        if (n == 0) return 1;
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }

//    ну чат че то напомогал и что? тот же самый TLE на n = 44

    public static int climbStairs(int n) {
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 1;
        for (int i = 1; i < n + 1; i++) {
            if (i - 1 > 0) ways[i] += ways[i - 1];
            if (i - 2 > 0) ways[i] += ways[i - 2];
        }
        return ways[n];
    }
//  beats 100% runtime 0ms memory 55%

    public static int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] ways = new int[2];
        ways[0] = 1;
        ways[1] = 2;
        int next = 0;
        for (int i = 0; i < n - 2; i++) {
            next = ways[0] + ways[1];
            ways[0] = ways[1];
            ways[1] = next;
        }
        return next;
    }


//    и вот такое решение иедальное по памяти нах. ток литкод показывает 29%
//    но память сейчас O(1) а была O(n)

    public static void main(String[] args) {
//        System.out.println(climbStairs(44));
//        System.out.println(climbStairs2(44));
        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
    }
}
