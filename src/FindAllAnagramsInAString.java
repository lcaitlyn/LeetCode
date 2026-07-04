import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

//    private static int[] makeMap(String p) {
//        int[] map = new int[26];
//        for (char c : p.toCharArray()) {
//            map[c - 'a']++;
//        }
//        return map;
//    }
//
//    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<>();
//        int[] set = makeMap(p);
//        int[] map = makeMap(p);
//        int l = 0, r = 0;
//
//        while (r < s.length()) {
//            char c = s.charAt(r);
//            if (r - l == p.length()) {
//                res.add(l);
//                map[s.charAt(l) - 'a']++;
//                l++;
//            } else if (set[c - 'a'] > 0) {
//                map[c - 'a']--;
//                if (map[c - 'a'] < 0) {
//                    while (map[c - 'a'] < 0) {
//                        map[s.charAt(l) - 'a']++;
//                        l++;
//                    }
//                }
//                if (r - l != p.length()) r++;
//            } else {
//                map = makeMap(p);
//                r++;
//                l = r;
//            }
//        }
//
//        if (r - l == p.length()) res.add(l);
//
//        return res;
//    }

//    beats 78.75% memory 37.81% runtime 10ms
//    пришлось подумать немного

//    upd 03.07.2026
//    лол. Там в коментах в сабмитах написано "Решалось за 9+ часов"
//    щас за мнут 10 решил окном

//    бля я даже не понимаю того решения что писал выше

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] set = new int[26];
        int size = 0;

        for (char c : p.toCharArray()) {
            if (set[c - 'a'] == 0) size++;
            set[c - 'a']++;
        }

        int[] map = new int[26];
        int l = 0, r = 0;
        while (r < s.length()) {
            int i = s.charAt(r) - 'a';
            map[i]++;
            if (map[i] == set[i]) size--;

            if (r - l + 1 > p.length()) {
                int j = s.charAt(l) - 'a';
                if (map[j] == set[j]) size++;
                map[j]--;
                l++;
            }

            if (size == 0) res.add(l);

            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
//        System.out.println(findAnagrams("bababab", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("abacbabc", "abc"));
    }
}
