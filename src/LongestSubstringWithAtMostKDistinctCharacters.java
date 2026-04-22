import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int res = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);

                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));

                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("qwqqqqqa", 2));
    }
}
