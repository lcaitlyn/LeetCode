package TBankContest2026Spring;

import java.util.Arrays;
import java.util.Scanner;

public class Program2 {

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        int lA = 0, rA = 0;

        while (l <= r && s.charAt(l) == 'a') {
            lA++;
            l++;
        }

        while (r >= l && s.charAt(r) == 'a') {
            rA++;
            r--;
        }

        if (rA < lA) return false;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        if (isPalindrome(s))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
