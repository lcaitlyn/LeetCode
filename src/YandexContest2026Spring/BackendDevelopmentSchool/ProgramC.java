package YandexContest2026Spring.BackendDevelopmentSchool;

import java.io.*;
import java.util.*;


public class ProgramC {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Math.abs(Long.parseLong(s[0]));
            arr[i][1] = Math.abs(Long.parseLong(s[1]));
        }

        Arrays.sort(arr, Comparator.comparingLong(a -> a[0]));

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 4);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            long max = 0;

            for (int j = i; j < n; j++) {
                max = Math.max(max, arr[j][1]);

                long cur = 4L * arr[j][0] * max;
                long min = dp[j + 1] + cur;

                dp[i] = Math.min(min, dp[i]);
            }
        }

        System.out.println(dp[0]);
    }
}
