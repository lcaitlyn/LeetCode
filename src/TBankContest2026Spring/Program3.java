package TBankContest2026Spring;

import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();

        long MOD = 1000000007L;
        long[] dp = new long[n + 1];

        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long prev = (m % MOD * ((m - 1) % MOD)) % MOD;
            long sum = (dp[i - 1] * prev) % MOD;

            long badA = (m - 2) * dp[i - 1] % MOD;
            long badB = (m - 2) * dp[i - 1] % MOD;
            long badAB = dp[i - 1];

            dp[i] = (sum - badA - badB - badAB + 3 * MOD) % MOD;
        }

        long total = (m % MOD * ((m - 1) % MOD)) % MOD;
        System.out.println((dp[n] * total) % MOD);
    }
}
