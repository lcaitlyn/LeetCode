package TBankContest2026Winter;

import java.util.Arrays;
import java.util.Scanner;

//public class Program2 {
//
//    public static void main(String[] args) {
//        String study = "study", tbank = "tbank";
//        int res = Integer.MAX_VALUE;
//
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//
//        int l = 0;
//        while (l + 4 < s.length()) {
//            int minStudy = 0;
//
//            for (int i = 0; i < 5; i++) {
//                if (s.charAt(l + i) != study.charAt(i)) {
//                    minStudy++;
//                }
//            }
//
//            int r = (l - 5 >= 0) ? 0 : l + 5;
//            while (r + 4 < s.length()) {
//                int minTbank = 0;
//
//                for (int i = 0; i < 5; i++) {
//                    if (s.charAt(r + i) != tbank.charAt(i)) {
//                        minTbank++;
//                    }
//                }
//
//                res = Math.min(res, minTbank + minStudy);
//                r++;
//            }
//
//            l++;
//        }
//
//        System.out.println(res);
//    }
//}
public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String study = "study";
        String tbank = "tbank";
        int n = s.length();

        int[] costStudy = new int[n];
        int[] costTbank = new int[n];

        for (int i = 0; i + 4 < n; i++) {
            int c1 = 0, c2 = 0;
            for (int j = 0; j < 5; j++) {
                if (s.charAt(i + j) != study.charAt(j)) c1++;
                if (s.charAt(i + j) != tbank.charAt(j)) c2++;
            }
            costStudy[i] = c1;
            costTbank[i] = c2;
        }

        int[] prefMinTbank = new int[n];
        int[] sufMinTbank = new int[n];
        Arrays.fill(prefMinTbank, Integer.MAX_VALUE);
        Arrays.fill(sufMinTbank, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (i + 4 < n) prefMinTbank[i] = costTbank[i];
            if (i > 0) prefMinTbank[i] = Math.min(prefMinTbank[i], prefMinTbank[i - 1]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i + 4 < n) sufMinTbank[i] = costTbank[i];
            if (i + 1 < n) sufMinTbank[i] = Math.min(sufMinTbank[i], sufMinTbank[i + 1]);
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i + 4 < n; i++) {
            int cur = costStudy[i];
            if (i - 5 >= 0) res = Math.min(res, cur + prefMinTbank[i - 5]);
            if (i + 5 < n) res = Math.min(res, cur + sufMinTbank[i + 5]);
        }

        System.out.println(res);
    }
}
