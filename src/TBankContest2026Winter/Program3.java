package TBankContest2026Winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program3 {

//    private static int findMaxSubMatrix(int[][] a, int n) {
//        return 0;
//    }
//
//    private static int[][] makeMatrix(String s, int n) {
//        int[][] a = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                a[i][j] = s.charAt((i - j + n - 1) % n) - '0';
//                System.out.print(a[i][j]);
//            }
//            System.out.println();
//        }
//
//        return a;
//    }

    private static int findMaxOnes(String s) {
        int res = 0;

        if (s.charAt(0) == '1' && s.charAt(s.length() - 1) == '1') {
            int l = 0, r = 0;

            while (l < s.length() && s.charAt(l) != '0') l++;
            while (r < s.length() && s.charAt(s.length() - 1 - r) != '0') r++;

            if (l == s.length()) return s.length() * s.length();

            res = l + r;
        }

        int inside = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res = Math.max(res, inside);
                inside = 0;
            } else {
                inside++;
            }
        }

        inside = Math.max(res, inside);

        int i = 1, x = 0;
        while (inside >= i) {
            x = Math.max(x, inside * i);
            i++;
            inside--;
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            list.add(sc.nextLine());
        }

        for (int i = 0; i < t; i++) {
            System.out.println(findMaxOnes(list.get(i)));
        }
    }
}
