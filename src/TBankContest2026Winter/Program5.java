package TBankContest2026Winter;

import java.io.*;
import java.util.*;


public class Program5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] a = new int[n];

        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(split[i]);
        }

        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = positions.getOrDefault(a[i], new ArrayList<>());
            list.add(i);
            positions.put(a[i], list);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int value : positions.keySet()) {
            List<Integer> list = positions.get(value);

            if (list.size() == 1) {
                int i = list.get(0);
                int left = a[(i - 1 + n) % n];
                int right = a[(i + 1) % n];

                int min = Math.min(value, Math.min(left, right));
                int max = Math.max(value, Math.max(left, right));

                int res = n - 1;
                if (value != min && value != max) {
                    res = n;
                }

                map.put(value, res);
            } else {
                int total = 0;
                int k = list.size();

                for (int i = 0; i < k; i++) {
                    int cur = list.get(i);
                    int next = list.get((i + 1) % k);

                    int len = (i < k - 1) ? next - cur - 1 : n - cur + next - 1;

                    if (len <= 0) continue;

                    int leftFirst = a[(cur + 1) % n];
                    int leftSecond = a[(cur + 2) % n];
                    int leftMin = Math.min(value, Math.min(leftFirst, leftSecond));
                    int leftMax = Math.max(value, Math.max(leftFirst, leftSecond));
                    boolean leftOk = (value == leftMin || value == leftMax);

                    int rightFirst = a[(next - 1 + n) % n];
                    int rightSecond = a[(next - 2 + n) % n];
                    int rightMin = Math.min(value, Math.min(rightFirst, rightSecond));
                    int rightMax = Math.max(value, Math.max(rightFirst, rightSecond));
                    boolean rightOk = (value == rightMin || value == rightMax);

                    if (leftOk && rightOk) {
                        total += len;
                    } else {
                        total += len + 1;
                    }
                }

                map.put(value, total);
            }
        }

        int i = 0;
        while (i < map.size() - 1) {
            System.out.print(map.get(a[i]));
            System.out.print(' ');
            i++;
        }
        System.out.println(map.get(a[i]));
    }
}
