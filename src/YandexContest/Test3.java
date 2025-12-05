package YandexContest;

import java.util.Scanner;

public class Test3 {

    private static int solution(String j, String s) {
        int[] set = new int[26];
        int res = 0;

        for (char c : j.toCharArray()) set[c - 'a']++;

        for (char c : s.toCharArray()) {
            if (set[c - 'a'] > 0) res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String j = sc.nextLine();
        String s = sc.nextLine();
        System.out.println(solution(j, s));
    }
}
