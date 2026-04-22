import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

//    private static int maxSubstring(String s, int k, int start, int end) {
//        if (end - start < k) return 0;
//
//        int[] map = new int[26];
//
//        for (int i = start; i < end; i++) {
//            map[s.charAt(i) - 'a']++;
//        }
//
//        for (int i = start; i < end; i++) {
//            if (map[s.charAt(i) - 'a'] < k) {
//                int l = maxSubstring(s, k, start, i);
//                int r = maxSubstring(s, k, i + 1, s.length());
//                return Math.max(l, r);
//            }
//        }
//
//        return end - start;
//    }
//
//    public static int longestSubstring(String s, int k) {
//        return maxSubstring(s, k, 0, s.length());
//    }

//      runtime 65ms,  beats 40.10%, memory 55.5%

    public static int longestSubstring(String s, int k) {
        int[] set = new int[26];
        int unique = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (set[s.charAt(i) - 'a'] == 0) unique++;
            set[s.charAt(i) - 'a']++;
        }

        for (int i = 1; i <= unique; i++) {
            int[] map = new int[26];
            int count = 0, size = 0;
            int l = 0, r = 0;

            while (r < s.length()) {
                map[s.charAt(r) - 'a']++;

                if (map[s.charAt(r) - 'a'] == 1) size++;
                if (map[s.charAt(r) - 'a'] == k) count++;

                while (size > i) {
                    map[s.charAt(l) - 'a']--;

                    if (map[s.charAt(l) - 'a'] == 0) size--;
                    if (map[s.charAt(l) - 'a'] == k - 1) count--;

                    l++;
                }

                if (count == i) res = Math.max(res, r - l + 1);

                r++;
            }
        }

        return res;
    }

//    runtime 82ms beats 17.47% memory 82.35%
//    бля лол почему это медленнее.

    public static void main(String[] args) {
//        System.out.println("10 -> " + longestSubstring("aaaaaaaaabbbcccccddddd", 5));
//        System.out.println("3 -> " + longestSubstring("aaabb", 3));
        System.out.println("3 -> " + longestSubstring("aacbbbdc", 2));
    }
}
