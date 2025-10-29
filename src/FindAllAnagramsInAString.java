import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindAllAnagramsInAString {

    private static int[] makeMap(String p) {
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] set = makeMap(p);
        int[] map = makeMap(p);
        int l = 0, r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (r - l == p.length()) {
                res.add(l);
                map[s.charAt(l) - 'a']++;
                l++;
            } else if (set[c - 'a'] > 0) {
                map[c - 'a']--;
                if (map[c - 'a'] < 0) {
                    while (map[c - 'a'] < 0) {
                        map[s.charAt(l) - 'a']++;
                        l++;
                    }
                }
                if (r - l != p.length()) r++;
            } else {
                map = makeMap(p);
                r++;
                l = r;
            }
        }

        if (r - l == p.length()) res.add(l);

        return res;
    }

//    beats 78.75% memory 37.81% runtime 10ms
//    пришлось подумать немного

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
//        System.out.println(findAnagrams("bababab", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("abacbabc", "abc"));
    }
}
