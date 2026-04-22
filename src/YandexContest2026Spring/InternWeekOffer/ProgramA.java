package YandexContest2026Spring.InternWeekOffer;

import java.util.Scanner;

public class ProgramA {

    private static int binarySearch(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int med = (r - l) / 2 + l;
            if (arr[med] == k || arr[med] > k) {
                l = med + 1;
            } else {
                r = med - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] lines = s.split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);
        int[] arr = new int[n];
        s = sc.nextLine();
        lines = s.split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        System.out.println(binarySearch(arr, k));
        int count = 0;
        for (int i = 0; i < n && arr[i] >= k; i++) {
            count++;
        }
        System.out.println(count);
    }
}
