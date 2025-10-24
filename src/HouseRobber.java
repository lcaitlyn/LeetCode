public class HouseRobber {

    private static int run(int[] nums, int sum, int i) {
        if (i >= nums.length) return sum;

        return Math.max(run(nums, sum + nums[i], i + 2), run(nums, sum, i + 1));
    }

    public static int rob1(int[] nums) {
        return run(nums, 0, 0);
    }

//    ожидаемо тут TLE
//    Вопрос лишь в следующем как это сделать итеративно?
//    опять же думаю стоит создать карту максимальной стоимости для каждой клетки
//    как это сделать?

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int cur = dp[0];

        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = Math.max(dp[0], dp[1]);
            dp[1] = cur;
        }

        return Math.max(dp[0], dp[1]);
    }

//    beats 100% memory 98% runtime 0ms
//    ахуеено сам пришел к результату. немного подрочился


    public static void main(String[] args) {
//        System.out.println(rob(new int[]{1, 2, 3, 1}));
//        System.out.println(rob(new int[]{2,7,9,3,1}));
//        System.out.println(rob1(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
        System.out.println(rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
        System.out.println(rob(new int[]{100, 1, 1, 100}));
    }
}
