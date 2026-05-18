package TBankContest2026Spring;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Program6 {

    public static long findMaxSum(int n, int a, int b, int[][] arr) {
        Arrays.sort(arr, (x, y) -> Integer.compare((y[0] - y[1]), (x[0] - x[1])));

        long[] pref = new long[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i][0];
            pq.add(arr[i][0]);
            if (pq.size() > a) {
                sum -= pq.poll();
            }
            pref[i] = (pq.size() == a) ? sum : 0;
        }

        long[] suff = new long[n];
        pq = new PriorityQueue<>();
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i][1];
            pq.add(arr[i][1]);
            if (pq.size() > b) {
                sum -= pq.poll();
            }
            suff[i] = (pq.size() == b) ? sum : 0;
        }


        if (b == 0) return pref[n - 1];
        if (a == 0) return suff[0];

        long res = 0;
        for (int i = a - 1; i < n - b; i++) {
            res = Math.max(res, pref[i] + (i + 1 < n ? suff[i + 1] : 0));
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] split = sc.nextLine().split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int n = Integer.parseInt(split[2]);

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            split = sc.nextLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            arr[i][0] = x;
            arr[i][1] = y;
        }

        System.out.println(findMaxSum(n, a, b, arr));
    }
}
