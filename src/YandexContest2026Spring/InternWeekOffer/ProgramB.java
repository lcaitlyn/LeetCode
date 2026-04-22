package YandexContest2026Spring.InternWeekOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProgramB {

    private static boolean[] makePrimeMap(int n) {
        boolean[] map = new boolean[n + 1];
        Arrays.fill(map, true);
        map[0] = false;
        map[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (map[i]) {
                for (int j = i * i; j <= n; j += i) {
                    map[j] = false;
                }
            }
        }

        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        boolean[] map = makePrimeMap(n);

        List<Integer> list = new ArrayList<>();

        if (map[n]) {
            list.add(n);
        } else if (n % 2 == 0) {
            for (int i = 2; i <= n; i++) {
                if (map[i] && map[n - i]) {
                    list.add(i);
                    list.add(n - i);
                    break;
                }
            }
        } else if (map[n - 2]) {
            list.add(2);
            list.add(n - 2);
        } else {
            for (int i = 2; i <= n; i++) {
                if (map[i] && map[n - 3 - i]) {
                    list.add(3);
                    list.add(i);
                    list.add(n - i - 3);
                    break;
                }
            }
        }

        System.out.println(list.size());
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.getLast());
    }
}
