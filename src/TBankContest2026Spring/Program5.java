package TBankContest2026Spring;

import java.util.Scanner;

public class Program5 {

    public static int minOperations(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int[][] dp = new int[n][n];
        char[] chars = {'T', 'O', 'I'};

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                char c = s.charAt(i);
                int j = i + len - 1;

                if (i == j) {
                    dp[i][j] = (c == 'T' || c == 'O' || c == 'I') ? 0 : 1;
                    continue;
                }

                int res = Math.min(1 + dp[i + 1][j], 1 + dp[i][j - 1]);

                for (char ch : chars) {
                    int totalI = (s.charAt(i) == ch) ? 0 : 1;
                    int totalJ = (s.charAt(j) == ch) ? 0 : 1;

                    int total = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;

                    res = Math.min(res, totalI + totalJ + total);
                }

                dp[i][j] = res;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(minOperations(s));
    }
}
