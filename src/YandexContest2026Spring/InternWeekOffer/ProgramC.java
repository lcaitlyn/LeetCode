package YandexContest2026Spring.InternWeekOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        String s = sc.nextLine();
        String[] lines = s.split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                list.add((i + 1) % n);
            }
        }

        if (list.size() == 1) list.add(list.get(0));

        System.out.println(list.get(0) + " " + list.get(1));
    }
}
