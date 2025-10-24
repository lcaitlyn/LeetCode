public class MinCostClimbingStairs {

//    private static int count(int [] cost, int sum, int i) {
//        if (i >= cost.length) return sum;
//
//        sum += cost[i];
//        return Math.min(count(cost, sum,i + 1), count(cost, sum,i + 2));
//    }
//
//    public static int minCostClimbingStairs(int[] cost) {
//        return Math.min(count(cost, 0, 0), count(cost, 0,1));
//    }

//    так ну ожидаемое TLE на 259/285 тесте


    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        int prevprev = cost[0];
        int prev = cost[1];

        int cur = 0;
        for (int i = 2; i < cost.length; i++) {
            cur = cost[i] + Math.min(prev, prevprev);
            prevprev = prev;
            prev = cur;
        }
        return Math.min(prev, prevprev);
    }

//    beats 100% memory 90% 0ms runtime.
//    ну хз похоже на предыдущее задание ClimbingStairs
//    и то до такого ответа с помощь ГПТ дошел (ну он идею только помог полностью сформулировать)


    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}
