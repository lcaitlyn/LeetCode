import java.util.LinkedList;
import java.util.Queue;

public class TakeKOfEachCharacterFromLeftAndRight {

    public static int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        if (s.length() < 3 * k) return -1;

        int res = s.length();
        int[] map = new int[3];

        for (char c : s.toCharArray())
            map[c - 'a']++;

        for (int a : map)
            if (a < k) return -1;

        int l = 0, r = 0;
        while (r < s.length()) {
            while (map[s.charAt(r) - 'a'] <= k) {
                map[s.charAt(l) - 'a']++;
                l++;
            }

            map[s.charAt(r) - 'a']--;
            res = Math.min(res, s.length() - (r - l + 1));
            r++;
        }
        return res;
    }

//    runtime 9ms beats 96.76% memory 33.81%

    public static void main(String[] args) {
//        System.out.println("8 -> " + takeCharacters("aabaaaacaabc", 2));
//        System.out.println("3 -> " + takeCharacters("abc", 1));
//        System.out.println("3 -> " + takeCharacters("acba", 1));
//        System.out.println("3 -> " + takeCharacters("caccbbba", 1));
    }
}
