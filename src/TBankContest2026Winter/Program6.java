package TBankContest2026Winter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program6 {

    private static char findIndex(String s, int l, int r, int i) {
        if (l == -1) return s.charAt(i);

        int len = r - l + 1;

        if (i < l) return s.charAt(i);

        if (i < l + 2 * len) return s.charAt(l + (i - l) / 2);

        return s.charAt(i - len);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] str =  sc.nextLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);

        String s = sc.nextLine();

        List<String []> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            list.add(sc.nextLine().split(" "));
        }

        int l = -1, r = -1, i;
        for (String [] split : list) {

            if (split[0].charAt(0) == '1') {
                l = Integer.parseInt(split[1]) - 1;
                r = Integer.parseInt(split[2]) - 1;
            } else {
                i = Integer.parseInt(split[1]);
                System.out.println(findIndex(s, l, r, i - 1));
            }
        }
    }
}
