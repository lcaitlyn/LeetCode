import java.util.Arrays;

public class HouseRobberII {

//    private static int run(int [] nums, int sum, int i) {
//        if (i >= nums.length) return sum;
//
//        return Math.max(run(nums, sum + nums[i], i + 2), run(nums, sum, i + 1));
//    }
//
//    public static int rob(int[] nums) {
//        if (nums.length == 1) return nums[0];
//
//        return Math.max(run(Arrays.copyOfRange(nums, 0, nums.length - 1), 0, 0), run(Arrays.copyOfRange(nums, 1, nums.length), 0, 0));
//    }

//    закономерно выпал TLE
//    но тогда если запуск у нас одинаковый, то мб просто сделать House Robber 1 и запустить его 2 раза
//    с разными длинами да и всё?

    private static int run(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[2];
        dp[0] = nums[0]; // i - 2
        dp[1] = nums[1]; // i - 1
        int cur = dp[0];
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = Math.max(dp[0], dp[1]);
            dp[1] = cur;
        }
        return Math.max(dp[0], dp[1]);
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        return Math.max(
                run(Arrays.copyOf(nums, nums.length - 1)),
                run(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

//    beats 100% memory 91%

    public static void main(String[] args) {
        System.out.println(rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
        System.out.println(rob(new int[]{2,3,2}));
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{1,2,3}));
    }
}
