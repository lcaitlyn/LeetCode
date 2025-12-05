package TinkoffContest;

import java.util.Scanner;

public class Program3 {

//    private static int rec(int cur, int total, int n, int k, int j) {
//        if (total == n) return 1;
//        if (cur > n || total > n) return 0;
//        int self = 0;
//        if (total + cur <= n) self = rec(cur, total + cur, n, k, j);
//        int next = 0;
//        if (j > 0) {
//            next = rec(cur, total + cur, n, k, j - 1);
//        }
//
//            int up = rec(cur + 1, total, n, k, k - 1);
//        return self + next + up;
//    }

    private static int rec(int[] nums, int total, int i, int n) {
        if (i == nums.length || total > n) return 0;
        if (total == n) return 1;
        return rec(nums, total + nums[i], i, n) + rec(nums, total, i + 1, n);
    }

    private static int find(int [] nums, int n) {
        int[][] dp = new int[nums.length + 1][n + 1];
        dp[nums.length][0] = 1; // базовый случай: 1 способ получить 0 (ничего не брать)

        for (int i2 = nums.length - 1; i2 >= 0; i2--) {
            for (int sum = 0; sum <= n; sum++) {
                int res = dp[i2 + 1][sum]; // не берем nums[i2]
                if (sum - nums[i2] >= 0) {
                    res += dp[i2][sum - nums[i2]]; // берем nums[i2]
                }
                dp[i2][sum] = res;
            }
        }

        return dp[0][n];
    }

//    я его рот ебал так просто это решалось, а я убил 2 часа га это говно

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] nums = new int[n * k];

        int i = 0, cur = 1;
        while (i < n * k) {
            int j = 0;
            while (j < k) {
                nums[i] = cur;
                i++;
                j++;
            }
            cur++;
        }

        System.out.println(find(nums, n));
        System.out.println(rec(nums, 0, 0, n));
    }
}
