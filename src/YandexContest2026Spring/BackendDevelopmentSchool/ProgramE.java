package YandexContest2026Spring.BackendDevelopmentSchool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ProgramE {

    private static long run(int i, int n, long[] h, long[] b) {
        for (int j = 0; j < n; j++) {
            b[j] = h[j] + Math.abs(i - (j + 1));
        }

        Arrays.sort(b);

        long med = b[n / 2];
        long min = 1L + Math.max(i - 1, n - i);
        long max = Math.max(med, min);

        long cost = 0;
        for (long l : b) {
            cost += Math.abs(l - max);
        }
        return cost;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = Integer.parseInt(s);

        long[] h = new long[n];
        long[] b = new long[n];

        String[] lines = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            h[i] = Long.parseLong(lines[i]);
        }

        int l = 1, r = n;
        while (r - l > 2) {
            int med1 = l + (r - l) / 3;
            int med2 = r - (r - l) / 3;

            if (run(med1, n, h, b) < run(med2, n, h, b)) {
                r = med2;
            } else {
                l = med1;
            }
        }

        long res = Long.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            res = Math.min(res, run(i, n, h, b));
        }

        System.out.println(res);
    }
}
